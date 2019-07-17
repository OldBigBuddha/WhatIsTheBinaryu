package dev.oldbigbuddha.whatisthebinary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_result.view.*

class ResultAdapter(
    _context: Context,
    private val list: List<QuizResult>
) : BaseAdapter() {


    private val layoutInflater =
        _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.item_result, parent, false)
        val result = getItem(position)
        view.tv_index_of_question.text = (position + 1).toString()
        view.tv_question_result.text = result.question
        view.tv_user_answer.text = result.userAnswer
        view.tv_correct_answer.text = result.correctAnswer
        return view
    }

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = list.size
}

data class QuizResult(
    val question: String,
    val userAnswer: String,
    val correctAnswer: String
) {
    companion object {
        fun makeSampleList(count: Int): List<QuizResult> {
            val list = arrayListOf<QuizResult>()
            for (i in 0 until count) {
                list.add(QuizResult("Question sample", "PNG", "GZIP"))
            }
            return list
        }
    }
}