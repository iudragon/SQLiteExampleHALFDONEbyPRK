package dragon.bakuman.iu.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {

    private Button bnSave;
    EditText email;
    EditText iD;
    EditText namee;


    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        bnSave = view.findViewById(R.id.bn_save);
        iD = view.findViewById(R.id.text_coontact_id);
        namee = view.findViewById(R.id.text_contact_name);
        email = view.findViewById(R.id.text_contact_email);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = iD.getText().toString();
                String emaile = email.getText().toString();
                String name = namee.getText().toString();

                //from this method, we can put the information into the database
                //first we have to create the object of contactDbHelper class (SQLiteOpenHelper)

                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase database = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id), name, emaile, database);
                contactDbHelper.close();

                iD.setText("");
                namee.setText("");
                email.setText("");

                Toast.makeText(getActivity(), "Contact Saved Successfully", Toast.LENGTH_SHORT).show();


            }
        });

        return view;
    }

}
