package com.bmpl.pdfview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.shockwave.pdfium.PdfDocument


class MainActivity : AppCompatActivity(), OnPageChangeListener, OnLoadCompleteListener, View.OnTouchListener {


    override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {

        if (motionEvent != null) {
            if(motionEvent.equals(MotionEvent.EDGE_LEFT)){

            }

        } //To change body of created functions use File | Settings | File Templates.
        return true;
    }


    private lateinit var pdfView: PDFView

    var PAGE_NUMBER = 0

    private lateinit var pdfFileName: String

    var array = arrayOf("big_nerd.pdf", "finalmorning.pdf")

    private val SAMPLE_FILE = "finalmorning.pdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pdfView = findViewById(R.id.pdfView) as PDFView

        //pdfView.setOnTouchListener(this)
        // intent
        var position = 1

        displayFromAsset(array[position])

    }
    /*
    //listView.setOnItemClickListener-> position : Int{
        if(index == 0){
        displayFromAsset("File1.pdf")
        } else if(index == 1){
        displayFromAsset("File2.pdf")
        } else if(index == 2)

    //}
*/
    private fun displayFromAsset(assetFileName: String) {
        pdfFileName = assetFileName

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(PAGE_NUMBER)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(DefaultScrollHandle(this))
                .spacing(10) // in dp
                .pageFitPolicy(FitPolicy.WIDTH)
                .load()
    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        PAGE_NUMBER = page
        title = String.format("%s %s / %s", pdfFileName, page + 1, pageCount)
    }

    override fun loadComplete(nbPages: Int) {
        //val meta = pdfView.documentMeta
        printBookmarksTree(pdfView.tableOfContents, "-")

    }

    private fun printBookmarksTree(tree: List<PdfDocument.Bookmark>, sep: String) {
        for (b in tree) {

            //Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.children, sep + "-")
            }
        }
    }

/*    companion object {
        val SAMPLE_FILE = "big_nerd.pdf"
    }*/
}