package practice.app.project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_list, container, false)

        var obj = DatabaseHelper(activity!!)//here should be your database but it isn't working
        var db = obj.readableDatabase
        var cur = db.rawQuery("select * from tasks",null)
        cur.moveToFirst()
        var list = ArrayList<String>()
        while(!cur.isAfterLast){

            list.add(cur.getString(0) + "\n" + cur.getString(1))
            cur.moveToNext()
            var adp= ArrayAdapter(activity!!,android.R.layout.simple_list_item_1,list)
            listView_tasks.adapter=adp
        }
        return v
}}
