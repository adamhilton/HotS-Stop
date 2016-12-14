package com.nonnulldev.hotsstop.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ListAdapter
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.nonnulldev.hotsstop.App
import com.nonnulldev.hotsstop.R
import com.nonnulldev.hotsstop.data.model.Hero
import com.nonnulldev.hotsstop.injection.component.DaggerMainScreenComponent
import com.nonnulldev.hotsstop.ui.main.recyclerview.HeroesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @BindView(R.id.rv_heroes)
    lateinit var rvHeroes: RecyclerView

    @Inject
    lateinit protected var viewModel: MainScreenViewModel

    lateinit private var subscriptions: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        initializeUi()

        initMainScreenComponent()

        subscriptions = CompositeDisposable()

        initBindings()
    }

    private fun initializeUi() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
    }

    private fun initBindings() {
        subscriptions.addAll(
                viewModel.heroesObservable()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { it -> showData(it) }
        )
    }

    private fun initMainScreenComponent() {
        DaggerMainScreenComponent.builder()
                .appComponent(App.appComponent)
                .build()
                .inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        subscriptions.clear()
    }

    @OnClick(R.id.get_heroes_button)
    fun getDataButtonClicked() {
        viewModel.loadHeroes()
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    private fun showData(heroes: List<Hero>) {
        rvHeroes.adapter = HeroesAdapter(heroes)
    }
}
