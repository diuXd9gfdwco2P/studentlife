package com.yanis.studentlife;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of App Widget functionality.
 */
public class EventAppWidget extends AppWidgetProvider {
    // Intitulé de l'extra qui contient la direction du défilé
    private final static String EXTRA_DIRECTION = "extraDirection";

    // La valeur pour défiler vers la gauche
    private final static String EXTRA_PREVIOUS = "previous";

    // La valeur pour défiler vers la droite
    private final static String EXTRA_NEXT = "next";

    // Intitulé de l'extra qui contient l'indice actuel dans le tableau
    private final static String EXTRA_INDICE = "extraIndice";

    // Indice actuel dans le tableau des évènement
    private int indice = 0;

    private static List<evenement> eventList = new ArrayList();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.event_app_widget);
            views.setTextViewText(R.id.eventWidget, eventList.get(indice).getName());
            views.setTextViewText(R.id.dateWidget, eventList.get(indice).getDate().substring(0,4)+"/"+eventList.get(indice).getDate().substring(4,6)+"/"+eventList.get(indice).getDate().substring(6,8));
            Intent nextIntent = new Intent(context, EventAppWidget.class);
            nextIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            nextIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            nextIntent.putExtra(EXTRA_DIRECTION, EXTRA_NEXT);
            nextIntent.putExtra(EXTRA_INDICE, indice);
            Uri data = Uri.withAppendedPath(Uri.parse("WIDGET://widget/id/"), String.valueOf(R.id.next));
            nextIntent.setData(data);
            PendingIntent nextPending = PendingIntent.getBroadcast(context, 0, nextIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            views.setOnClickPendingIntent(R.id.next, nextPending);

            Intent previousIntent = new Intent(context, EventAppWidget.class);
            previousIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            previousIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            previousIntent.putExtra(EXTRA_DIRECTION, EXTRA_PREVIOUS);
            previousIntent.putExtra(EXTRA_INDICE, indice);
            data = Uri.withAppendedPath(Uri.parse("WIDGET://widget/id/"), String.valueOf(R.id.previous));
            previousIntent.setData(data);
            PendingIntent previousPending = PendingIntent.getBroadcast(context, 1, previousIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            views.setOnClickPendingIntent(R.id.previous, previousPending);
            // Et il faut mettre à jour toutes les vues
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }



    @Override
    public void onReceive(Context context, Intent intent) {
        if(eventList.size() == 0) {
            DataBaseEventHelper localDb = new DataBaseEventHelper(context);
            Cursor res = localDb.getAllData();
            while (res.moveToNext()) {
                eventList.add(
                        new evenement(
                                res.getString(1),
                                res.getString(2),
                                res.getString(3),
                                res.getString(4)));
            }
        }
        // Sinon, s'il s'agit d'une demande de mise à jour
        int tmp = intent.getIntExtra(EXTRA_INDICE, -1);

        // S'il y avait bien un indice passé
        if(tmp != -1) {
            // On récupère la direction
            String extra = intent.getStringExtra(EXTRA_DIRECTION);
            // Et on calcule l'indice voulu par l'utilisateur
            if (extra.equals(EXTRA_PREVIOUS)) {
                indice = (tmp - 1) % eventList.size();
                if(indice < 0)
                    indice += eventList.size();
            } else if(extra.equals(EXTRA_NEXT))
                indice = (tmp + 1) % eventList.size();
        }
        // On revient au traitement naturel du Receiver, qui va lancer onUpdate s'il y a demande de mise à jour
        super.onReceive(context, intent);
    }

}

