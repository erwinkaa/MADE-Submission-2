package id.erwinka.madesubmission2.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.erwinka.madesubmission2.R
import id.erwinka.madesubmission2.detail.DetailFilmActivity
import org.jetbrains.anko.support.v4.startActivity

class FilmFragment : Fragment() {

    private lateinit var adapter: FilmAdapter
    private lateinit var recyclerView: RecyclerView
    private var datas = mutableListOf<FilmModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerview)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val type = arguments?.getString(MainActivity.BUNDLE_EXTRA)
        if (type.equals(MainActivity.MOVIE)) {
            initData(MainActivity.MOVIE)
        } else if (type.equals(MainActivity.TVSHOW)) {
            initData(MainActivity.TVSHOW)
        }

        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = FilmAdapter(requireContext(), datas) {
            startActivity<DetailFilmActivity>(MainActivity.DATA_EXTRA to it)
        }
        recyclerView.adapter = adapter

        super.onActivityCreated(savedInstanceState)
    }

    fun initData(type: String) {
        if (type.equals(MainActivity.MOVIE)) {
            val titles = resources.getStringArray(R.array.movie_titles)
            val descriptions = resources.getStringArray(R.array.movie_descriptions)
            val posters = resources.obtainTypedArray(R.array.movie_posters)
            val releaseDates = resources.getStringArray(R.array.movie_releasedates)
            val runningTimes = resources.getStringArray(R.array.movie_runningtimes)
            val distributedBy = resources.getStringArray(R.array.movie_distributedby)
            datas.clear()
            for (i in titles.indices) {
                datas.add(
                    FilmModel(
                        titles[i],
                        descriptions[i],
                        posters.getResourceId(i, 0),
                        releaseDates[i],
                        runningTimes[i],
                        distributedBy[i]
                    )
                )
            }
            posters.recycle()
        } else if (type.equals(MainActivity.TVSHOW)) {
            val titles = resources.getStringArray(R.array.tvshow_titles)
            val descriptions = resources.getStringArray(R.array.tvshow_descriptions)
            val posters = resources.obtainTypedArray(R.array.tvshow_posters)
            val releaseDates = resources.getStringArray(R.array.tvshow_releasedates)
            val runningTimes = resources.getStringArray(R.array.tvshow_runningtimes)
            val distributedBy = resources.getStringArray(R.array.tvshow_distributedby)
            datas.clear()
            for (i in titles.indices) {
                datas.add(
                    FilmModel(
                        titles[i],
                        descriptions[i],
                        posters.getResourceId(i, 0),
                        releaseDates[i],
                        runningTimes[i],
                        distributedBy[i]
                    )
                )
            }
            posters.recycle()
        }
    }

}
