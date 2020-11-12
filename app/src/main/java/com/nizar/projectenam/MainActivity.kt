package com.nizar.projectenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textData = createPhoneData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ContactAdapter(textData, {phoneItem : PhoneData -> phoneItemClicked(phoneItem) })
    }

    private fun phoneItemClicked(phoneItem : PhoneData) {
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, phoneItem.contactName)
        startActivity(showDetailActivityIntent)

    }

    private fun createPhoneData(): List<PhoneData> {
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(6289787551200,"Naomi"))
        partList.add(PhoneData(6293500123856,"Arin"))
        partList.add(PhoneData(6299204810446,"Nizar"))
        partList.add(PhoneData(6299205422446,"Zulmi"))
        partList.add(PhoneData(6299204810746,"Riri"))
        partList.add(PhoneData(6275388346046,"Nomnom"))
        return partList
    }

}
