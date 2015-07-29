package sensorapp.shdccontactor;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<DCMember> memberList;
    private DCMemberAdapter adapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        Log.d("ContactsTitleFragment", "onAttach");
        memberList = getMembers();
        adapter = new DCMemberAdapter(activity, R.layout.members_item, memberList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView contactTitleListView;
        View view = inflater.inflate(R.layout.contacts_title_frag, container, false);
        Log.d("ContactsTitleFragment", "onCreateView");
        contactTitleListView = (ListView) view.findViewById(R.id.contacts_title_list_view);
        contactTitleListView.setAdapter(adapter);
        contactTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.contacts_content_layout) != null){
            isTwoPane = true;
            Log.d("ContactsTitleFragment", "it is two panel.");
        }
        else{
            isTwoPane = false;
            Log.d("ContactsTitleFragment", "it is not two panel.");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        DCMember dcMember = memberList.get(position);
        if(isTwoPane){
            Log.d("ContactsTitleFragment", "This is Two Pane.");
            Log.d("ContactsTitleFragment", "member is "+ dcMember.getChiName());
            MemberContentFragment memberContentFragment = (MemberContentFragment)
                    getFragmentManager().findFragmentById(R.id.contacts_content_fragment);
            memberContentFragment.refresh(dcMember.getChiName(), dcMember.getEngName(), dcMember
            .getMobNumber(), dcMember.getEmail());
        } else {
            Log.d("ContactsTitleFragment", "This is One Pane.");
            Log.d("ContactsTitleFragment", "member is "+ dcMember.getChiName());
            ContactContentActivity.actionStart(getActivity(),dcMember.getChiName(), dcMember.getEngName(),
                    dcMember.getEmail(), dcMember.getMobNumber());
        }
    }

    private List<DCMember> getMembers(){
        List<DCMember> dcMemberList = new ArrayList<>();

        DCMember dcMember1 = new DCMember();
        dcMember1.setChiName("Jin Donghui");
        dcMember1.setEngName("Daniel");
        dcMember1.setEmail("daniel.jin@rohm.com.cn");
        dcMember1.setMobNumber("13817862106");
        dcMemberList.add(dcMember1);

        DCMember dcMember2 = new DCMember();
        dcMember2.setChiName("Mi Ying");
        dcMember2.setEngName("Andy");
        dcMember2.setEmail("andy.jin@rohm.com.cn");
        dcMember2.setMobNumber("13817870320");
        dcMemberList.add(dcMember2);

        return dcMemberList;
    }

}
