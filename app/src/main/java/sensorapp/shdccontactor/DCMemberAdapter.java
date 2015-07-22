package sensorapp.shdccontactor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DCMemberAdapter extends ArrayAdapter<DCMember> {

    private int resourceId;

    public DCMemberAdapter(Context context, int textViewResourceId, List<DCMember> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        DCMember dcMember = getItem(position);
        View view;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convertView;
        }

        TextView dcMemberName = (TextView) view.findViewById(R.id.dcMember_name);
        dcMemberName.setText(dcMember.getChiName() + "(" + dcMember.getEngName() + ")");
        return view;
    }
}