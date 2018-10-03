package me.murks.feedwatcher.activities

import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TextView
import me.murks.feedwatcher.R
import me.murks.feedwatcher.model.Result

class ResultActivity : FeedWatcherBaseActivity() {

    private lateinit var resultName: TextView
    private lateinit var resultDescription: TextView
    private lateinit var resultFeed: TextView
    private lateinit var resultDate: TextView
    private lateinit var resultLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultName = findViewById(R.id.result_result_name)
        resultDescription = findViewById(R.id.result_result_description)
        resultFeed = findViewById(R.id.result_result_feed)
        resultDate = findViewById(R.id.result_result_date)
        resultLink = findViewById(R.id.result_result_link)

        val result = intent.getParcelableExtra<Result>(RESULT_EXTRA_NAME)

        resultName.text = result.item.title
        resultDescription.text = result.item.description
        resultFeed.text = result.feedName
        resultDate.text = DateFormat.getDateFormat(this).format(result.found) +
                " " + DateFormat.getTimeFormat(this).format(result.found)
        resultLink.text = result.item.link?.toString() ?: ""
    }

    companion object {
        const val RESULT_EXTRA_NAME = "result"
    }
}