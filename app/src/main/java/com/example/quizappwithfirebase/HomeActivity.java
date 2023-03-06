package com.example.quizappwithfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class HomeActivity extends AppCompatActivity {

    int[] images = {R.drawable.c,R.drawable.c,R.drawable.java,R.drawable.javascript,R.drawable.python,R.drawable.sql};
    String[] texts = {"C Language","C++ Language","Java Language","JavaScript","Python","Mysql"};
    String[] texts1 = {"C is a general-purpose programming language that is extremely popular, simple, and flexible to use. It was created by Dennis Ritchie at Bell Laboratories in 1972.",
            "C++ is a high-level general-purpose programming language created by Danish computer scientist Bjarne Stroustrup and first released in 1985 as an extension of the C programming language.",
            "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible\n 1. It was developed by Sun Microsystems (which is now a subsidiary of Oracle) in 1995.",
            "JavaScript is a high-level programming language that conforms to the ECMAScript standard\n 1. JavaScript enables you to create dynamically updating content, control multimedia, animate images and much more on web pages.",
            "Python is an interpreted, high-level, general-purpose programming language\n 1. Python is widely used for web development, scientific computing, data analysis and more.",
            "MySQL is an open-source relational database management system (RDBMS)\n 1. It stores data in tables made up of rows and columns. Users can define, manipulate, control, and query data using Structured Query Language (SQL)."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),images,texts,texts1);
        listView.setAdapter(customAdapter);
    }


    class CustomAdapter extends BaseAdapter {

        Context context;
        int[] images;
        String[] texts;
       String[] texts1;
        LayoutInflater inflater;

        public CustomAdapter(Context context, int[] images, String[] texts,String[] texts1) {
            this.context = context;
            this.images = images;
            this.texts = texts;
            this.texts1 = texts1;
            inflater = (LayoutInflater.from(getApplicationContext()));
        }

        @Override
        public int getCount() {
            return texts.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            view = inflater.inflate(R.layout.custom_layout,null);

            ImageView imageView = view.findViewById(R.id.card_image);
            TextView textView = view.findViewById(R.id.card_text);
            TextView textView1 = view.findViewById(R.id.card_text1);

            imageView.setImageResource(images[i]);
            textView.setText(texts[i]);
            textView1.setText(texts1[i]);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (i){
                        case 0:
                            Toast.makeText(getApplicationContext(),"C language", Toast.LENGTH_SHORT).show();
                            break;

                        case 1:
                            Toast.makeText(getApplicationContext(),"C++ language", Toast.LENGTH_SHORT).show();
                            break;

                        case 2:
                            Toast.makeText(getApplicationContext(),"java", Toast.LENGTH_SHORT).show();
                            break;

                        case 3:
                            Toast.makeText(getApplicationContext(),"javaScript", Toast.LENGTH_SHORT).show();
                            break;

                        case 4:
                            Toast.makeText(getApplicationContext(),"Python", Toast.LENGTH_SHORT).show();
                            break;

                        case 5:
                            Toast.makeText(getApplicationContext(),"Sql", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            });

            return view;
        }
    }
}