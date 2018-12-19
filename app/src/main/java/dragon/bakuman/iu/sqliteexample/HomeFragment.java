package dragon.bakuman.iu.sqliteexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button bnSave, bnView, bnDelete, bnUpdate;

    OnDbOpListener dbOpListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    //this fragment needs to communicate with the activity. So we create the interface
    public interface OnDbOpListener{

        void dbOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bnSave = view.findViewById(R.id.bn_add_contact);
        bnSave.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bn_add_contact:
                dbOpListener.dbOpPerformed(0);
                break;


        }


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        try{
            dbOpListener = (OnDbOpListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must implement the interface method");


        }


    }
}
