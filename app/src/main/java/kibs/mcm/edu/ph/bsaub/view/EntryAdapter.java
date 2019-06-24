package kibs.mcm.edu.ph.bsaub.view;

import androidx.recyclerview.widget.RecyclerView;

//AndroidX replacement libraries
//import androidx.core.content.ContextCompat;
//import androidx.appcompat.widget.AppCompatTextView;
//import androidx.core.view.ViewCompat;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kibs.mcm.edu.ph.bsaub.model.SqliteEntry;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.MyViewHolder> {

    private Context context;
    private List<SqliteEntry> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView note;
        public TextView dot;
        public TextView timestamp;

        public MyViewHolder(View view) {
            super(view);
        //    note = view.findViewById(R.id.note);
        //    dot = view.findViewById(R.id.dot);
        //    timestamp = view.findViewById(R.id.timestamp);
        }
    }


    public NotesAdapter(Context context, List<SqliteEntry> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SqliteEntry note = notesList.get(position);

        holder.note.setText(note.getSname());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(note.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}
