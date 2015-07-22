package sensorapp.shdccontactor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MemberContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_contact_info, container, false);
        return view;
    }

    public void refresh(String chiName, String engName, String mobNumber, String email){
        View visibleLayout = view.findViewById(R.id.visible_layout);
        visibleLayout.setVisibility(View.VISIBLE);
        TextView dcMemberChiName = (TextView) view.findViewById(R.id.dcMember_chiName);
        TextView dcMemberEngName = (TextView) view.findViewById(R.id.dcMember_engName);
        TextView dcMemberMobNumber = (TextView) view.findViewById(R.id.dcMember_mobNumber);
        TextView dcMemberEmail = (TextView) view.findViewById(R.id.dcMember_email);
        dcMemberChiName.setText(chiName);
        dcMemberEngName.setText(engName);
        dcMemberEmail.setText(email);
        dcMemberMobNumber.setText(mobNumber);
    }
}