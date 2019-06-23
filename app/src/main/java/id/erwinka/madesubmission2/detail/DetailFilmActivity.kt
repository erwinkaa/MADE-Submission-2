package id.erwinka.madesubmission2.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import id.erwinka.madesubmission2.R
import id.erwinka.madesubmission2.main.FilmModel
import id.erwinka.madesubmission2.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail_film.*

class DetailFilmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title = "Detail Film"

        val data = intent.getParcelableExtra<FilmModel>(MainActivity.DATA_EXTRA)

        tv_film_title.text = data.title
        tv_film_releasedate.text = data.releaseDate
        tv_film_durationtime.text = data.runningTime
        tv_film_distributedby.text = data.distributedBy
        tv_film_description.text = data.description
        Glide.with(applicationContext).load(data.poster).into(iv_film_poster)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
