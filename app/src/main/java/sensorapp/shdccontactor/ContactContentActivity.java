package sensorapp.shdccontactor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class ContactContentActivity extends BaseActivity {
    public static void actionStart(Context context, String chiName, String engName, String email,
                                   String mobNumber){
        Intent intent = new Intent(context, ContactContentActivity.class);
        intent.putExtra("chi_name", chiName);
        intent.putExtra("eng_name", engName);
        intent.putExtra("email", email);
        intent.putExtra("mob_number", mobNumber);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.contacts_content);
        String chiName = getIntent().getStringExtra("chi_name");
        String engName = getIntent().getStringExtra("eng_name");
        String email = getIntent().getStringExtra("email");
        String mobNumber = getIntent().getStringExtra("mob_number");

        MemberContentFragment memberContentFragment = (MemberContentFragment) getFragmentManager()
                .findFragmentById(R.id.contacts_content_fragment);
        memberContentFragment.refresh(chiName, engName, mobNumber, email);
    }
}
