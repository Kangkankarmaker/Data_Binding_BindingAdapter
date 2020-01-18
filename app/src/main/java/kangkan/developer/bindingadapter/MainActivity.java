package kangkan.developer.bindingadapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kangkan.developer.bindingadapter.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding=DataBindingUtil .setContentView(this,R.layout.activity_main);



        student aStudent =new student("Kangkan Karmaker",22);
        binding.setAStudent(aStudent);

        aStudent.setImageUrl("https://untearable-trays.000webhostapp.com/image/mohera.png");

    }



    public class student{
        private String name;
        private int age;
        private String imageUrl;

        public student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }


    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView iv,String url)
    {
        Glide.with(iv.getContext())
                .load(url)
                .fitCenter()
                .into(iv);
    }


}
