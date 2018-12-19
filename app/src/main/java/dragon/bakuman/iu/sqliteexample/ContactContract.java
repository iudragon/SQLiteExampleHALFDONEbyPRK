package dragon.bakuman.iu.sqliteexample;

public final class ContactContract {

    //to avoid the accidental initialisation of this class, create a constructor


    public ContactContract() {

    }

    public static class ContactEntry{

        //in this class we specify database schema


        //table
        public static final String TABLE_NAME = "contact_info";

        //column
        public static final String CONTACT_ID = "contact_id";

        public static final String NAME = "name";

        public static final String EMAIL = "email";

    }
}
