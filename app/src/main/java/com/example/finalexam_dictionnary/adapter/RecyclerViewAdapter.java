package com.example.finalexam_dictionnary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexam_dictionnary.R;
import com.example.finalexam_dictionnary.model.Word;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Word> wordList;
    private onButtonClickListener mListener;

    public interface onButtonClickListener{
        void onClickDefinition(int position);
        void onClickTranslate(int position);
    }

    public void setOnItemClickListener(onButtonClickListener listener){mListener = listener;}

    public RecyclerViewAdapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word w = wordList.get(position);

        holder.wordName.setText(w.getWord());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView wordName;
        private Button definitionButton;
        private Button translateButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wordName=itemView.findViewById(R.id.wordName);
            definitionButton=itemView.findViewById(R.id.definitionButton);
            translateButton=itemView.findViewById(R.id.translateButton);

            definitionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onClickDefinition(position);
                        }
                    }
                }
            });

            translateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onClickTranslate(position);
                        }
                    }
                }
            });
        }
    }
}
