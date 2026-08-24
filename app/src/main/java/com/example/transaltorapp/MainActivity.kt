package com.example.transaltorapp

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions

class MainActivity : AppCompatActivity() {

    private lateinit var translator: Translator

    private val languageMap = mapOf(
        "Afrikaans" to TranslateLanguage.AFRIKAANS,
        "Albanian" to TranslateLanguage.ALBANIAN,
        "Arabic" to TranslateLanguage.ARABIC,
        "Belarusian" to TranslateLanguage.BELARUSIAN,
        "Bengali" to TranslateLanguage.BENGALI,
        "Bulgarian" to TranslateLanguage.BULGARIAN,
        "Catalan" to TranslateLanguage.CATALAN,
        "Chinese" to TranslateLanguage.CHINESE,
        "Croatian" to TranslateLanguage.CROATIAN,
        "Czech" to TranslateLanguage.CZECH,
        "Danish" to TranslateLanguage.DANISH,
        "Dutch" to TranslateLanguage.DUTCH,
        "English" to TranslateLanguage.ENGLISH,
        "Esperanto" to TranslateLanguage.ESPERANTO,
        "Estonian" to TranslateLanguage.ESTONIAN,
        "Finnish" to TranslateLanguage.FINNISH,
        "French" to TranslateLanguage.FRENCH,
        "Galician" to TranslateLanguage.GALICIAN,
        "Georgian" to TranslateLanguage.GEORGIAN,
        "German" to TranslateLanguage.GERMAN,
        "Greek" to TranslateLanguage.GREEK,
        "Gujarati" to TranslateLanguage.GUJARATI,
        "Haitian Creole" to TranslateLanguage.HAITIAN_CREOLE,
        "Hebrew" to TranslateLanguage.HEBREW,
        "Hindi" to TranslateLanguage.HINDI,
        "Hungarian" to TranslateLanguage.HUNGARIAN,
        "Icelandic" to TranslateLanguage.ICELANDIC,
        "Indonesian" to TranslateLanguage.INDONESIAN,
        "Irish" to TranslateLanguage.IRISH,
        "Italian" to TranslateLanguage.ITALIAN,
        "Japanese" to TranslateLanguage.JAPANESE,
        "Kannada" to TranslateLanguage.KANNADA,
        "Korean" to TranslateLanguage.KOREAN,
        "Latvian" to TranslateLanguage.LATVIAN,
        "Lithuanian" to TranslateLanguage.LITHUANIAN,
        "Macedonian" to TranslateLanguage.MACEDONIAN,
        "Malay" to TranslateLanguage.MALAY,
        "Maltese" to TranslateLanguage.MALTESE,
        "Marathi" to TranslateLanguage.MARATHI,
        "Norwegian" to TranslateLanguage.NORWEGIAN,
        "Persian" to TranslateLanguage.PERSIAN,
        "Polish" to TranslateLanguage.POLISH,
        "Portuguese" to TranslateLanguage.PORTUGUESE,
        "Romanian" to TranslateLanguage.ROMANIAN,
        "Russian" to TranslateLanguage.RUSSIAN,
        "Slovak" to TranslateLanguage.SLOVAK,
        "Slovenian" to TranslateLanguage.SLOVENIAN,
        "Spanish" to TranslateLanguage.SPANISH,
        "Swahili" to TranslateLanguage.SWAHILI,
        "Swedish" to TranslateLanguage.SWEDISH,
        "Tagalog" to TranslateLanguage.TAGALOG,
        "Tamil" to TranslateLanguage.TAMIL,
        "Telugu" to TranslateLanguage.TELUGU,
        "Thai" to TranslateLanguage.THAI,
        "Turkish" to TranslateLanguage.TURKISH,
        "Ukrainian" to TranslateLanguage.UKRAINIAN,
        "Urdu" to TranslateLanguage.URDU,
        "Vietnamese" to TranslateLanguage.VIETNAMESE,
        "Welsh" to TranslateLanguage.WELSH
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val translateButton = findViewById<Button>(R.id.translate_button)
        val outputText = findViewById<TextView>(R.id.outputText)

        val sourceLanguageSpinner =
            findViewById<Spinner>(R.id.sourceLanguageSpinner)

        val targetLanguageSpinner =
            findViewById<Spinner>(R.id.targetLanguageSpinner)

        val languages = languageMap.keys.toTypedArray()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            languages
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        sourceLanguageSpinner.adapter = adapter
        targetLanguageSpinner.adapter = adapter

        sourceLanguageSpinner.setSelection(
            languages.indexOf("English")
        )

        targetLanguageSpinner.setSelection(
            languages.indexOf("Bengali")
        )

        onBackPressedDispatcher.addCallback(this) {

            if (inputEditText.hasFocus()) {

                inputEditText.clearFocus()

                val imm = getSystemService(
                    INPUT_METHOD_SERVICE
                ) as InputMethodManager

                imm.hideSoftInputFromWindow(
                    inputEditText.windowToken,
                    0
                )

            } else {
                finish()
            }
        }

        translateButton.setOnClickListener {

            val sourceLanguage =
                sourceLanguageSpinner.selectedItem.toString()

            val targetLanguage =
                targetLanguageSpinner.selectedItem.toString()

            val sourceCode = languageMap[sourceLanguage]
            val targetCode = languageMap[targetLanguage]

            val textToTranslate =
                inputEditText.text.toString().trim()

            if (textToTranslate.isEmpty()) {
                outputText.text = "Please enter some text"
                return@setOnClickListener
            }

            if (sourceCode == null || targetCode == null) {
                outputText.text = "Language not supported"
                return@setOnClickListener
            }

            if (::translator.isInitialized) {
                translator.close()
            }

            val options = TranslatorOptions.Builder()
                .setSourceLanguage(sourceCode)
                .setTargetLanguage(targetCode)
                .build()

            translator = Translation.getClient(options)

            outputText.text = "Downloading language model..."

            translator.downloadModelIfNeeded()
                .addOnSuccessListener {

                    translator.translate(textToTranslate)
                        .addOnSuccessListener { translatedText ->
                            outputText.text = translatedText
                        }
                        .addOnFailureListener { exception ->
                            outputText.text =
                                "Translation Failed: ${exception.message}"
                        }
                }
                .addOnFailureListener { exception ->
                    outputText.text =
                        "Model Download Failed: ${exception.message}"
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (::translator.isInitialized) {
            translator.close()
        }
    }
}