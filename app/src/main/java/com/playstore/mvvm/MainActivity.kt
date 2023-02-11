package com.playstore.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.playstore.mvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ListAdapter
    private lateinit var recyclerView: RecyclerView
    private var userList = ArrayList<User>()
    private lateinit var userDao: UserDao
    private lateinit var userDataBase: UserDataBase
    private val userApi = RetrofitHelper.getInstance().create(UserInterface::class.java)
    lateinit var viewModel: usersViewModel
    lateinit var dBViewModel: UsersDBViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //  recyclerView = findViewById(R.id.recyclerView)
        adapter = ListAdapter(userList)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = linearLayoutManager
        //userList.add(User(true,1,"Hello World",1))
        adapter = ListAdapter(userList)
        binding.recyclerView.adapter = adapter
        userDataBase = UserDataBase.getInstance(this)
        userDao = userDataBase.userDao()

        viewModel = ViewModelProvider(this,userViewModelFactory(usersRepository(userApi))).get(usersViewModel::class.java)

        dBViewModel = ViewModelProvider(this,UserViewDBModelFactory(UserDBRepository(userDao))).get(UsersDBViewModel::class.java)


        viewModel.userList.observe(this, Observer {
            Log.d("Bhaskar", "movieList: $it")
            adapter.setUserList(it)
            GlobalScope.launch {
                dBViewModel.insertUsers(it)
                dBViewModel.getAllUsers()
            }
            adapter.notifyDataSetChanged()
        })

        viewModel.getAllUserList()

        dBViewModel.userList.observe(this) {
            Log.d("Bhaskar", "movieList: DB $it")
        }

        /*GlobalScope.launch {
            userList = userApi.getPosts()
            Log.d("bhaskar: ", userList.toString())
        }*/
       /* Handler(Looper.getMainLooper()).postDelayed({
            adapter = ListAdapter(userList)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        },8000)*/




       /* GlobalScope.launch {
            delay(8000)
            userDao.inserUserList(userList)
            Log.d("bhaskar:1::", userDao.getUserList().toString())
        }*/



    }
}