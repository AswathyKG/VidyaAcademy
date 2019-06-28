package com.vidhya.vidyaacademy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewFor_PendingClasslist_Princi extends RecyclerView.Adapter<RecyclerViewFor_PendingClasslist_Princi.ViewHolder> {


    TextView tv_pending_classlist_class_name ;
    ArrayList<Pending_Classlist_Adpter> list;
    Context context;
    String AdminID;

    public RecyclerViewFor_PendingClasslist_Princi(Context context, ArrayList<Pending_Classlist_Adpter> arrayList, String adminID){
        this.list = arrayList;
        this.context = context;
        this.AdminID=adminID;
    }

    @NonNull
    @Override
    public RecyclerViewFor_PendingClasslist_Princi.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView view = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_pending_classlist_card_princi, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFor_PendingClasslist_Princi.ViewHolder viewHolder, final int i) {
        final int j;
        final CardView cardView = viewHolder.cardView;


        tv_pending_classlist_class_name= cardView.findViewById(R.id.tv_pending_classlist_class_name);
        tv_pending_classlist_class_name.setText(list.get(i).getS().toString());



        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent=new Intent( context,Pending_Studentlist.class );
                intent.putExtra( "ClassID",list.get( i ).getS() );
                intent.putExtra( "AdminID",AdminID );
                Log.e( "ClassId" ,list.get( i ).getS().toString());
                context.startActivity(intent);
*/
                Bundle bundle3=new Bundle();
                bundle3.putString( "ClassID",list.get( i ).getS() );
                bundle3.putString("AdminID",AdminID);

                Log.e("ClassID",list.get( i ).getS());

                Fragment fragment = new F_Princi_Pending_Studentlist();
                //FragmentManager fragmentManager = getFragmentManager();;
                fragment.setArguments( bundle3 );
                FragmentManager fragmentManager =  ((FragmentActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_princi, fragment);
                fragmentTransaction.addToBackStack(null);
                // fragmentTransaction.commit();*/

                fragmentTransaction.commit();

            }
        });

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        public ViewHolder(View view) {
            super(view);

            cardView = (CardView) view.findViewById(R.id.pending_classlist_cardview);

        }
    }

    @Override
    public int getItemCount() {
        int len = list.size();
        return len;
    }
}
