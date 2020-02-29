package practice.app.project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_new_task.*
import kotlinx.android.synthetic.main.fragment_new_task.view.*

/**
 * A simple [Fragment] subclass.
 */
class NewTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_new_task, container, false)
        v.button.setOnClickListener {
            var obj = DatabaseHelper(activity!!)
            var db = obj.writableDatabase
            db.execSQL("insert into tasks values(?)",
                arrayOf(editText_newTask.text.toString()))
            Toast.makeText(activity!!, "Saved", Toast.LENGTH_LONG).show()
        }




        return v
    }


}
