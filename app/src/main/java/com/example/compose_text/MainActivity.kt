package com.example.compose_text

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.compose_text.ui.theme.Compose_textTheme

//https://developer.android.google.cn/jetpack/compose/text#keyboard-options 文档
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_textTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        basicText(R.string.basic_text)
                        //设置文本颜色
                        colorText(R.string.basic_text)
                        //设置字号
                        sizeText(R.string.basic_text)
                        //设置文本的对其方式
                        alignText(R.string.basic_text)
                        //设置字体
                        diffFont(R.string.basic_text)
                        //设置子重
                        weightText(R.string.basic_text)
                        //设置样式
                        styleText(R.string.basic_text)
                        selectText(R.string.basic_text)
                        myselfStyleFont(R.string.basic_text)
                        mutableStyleIntText(R.string.basic_text)
                        paragraphStyle()
                        maxLineText()
                        maxCountText()
                        SimpleClickableText(this@MainActivity)
                        simpleFilledTextFieldSample()
                        simpleOutlineTextFieldSample()


                    }
                }
            }
        }
    }
}


@Composable
fun basicText(resId: Int) {
    Text(stringResource(id = resId))
}

@Composable
fun colorText(resId: Int) {
    Text(stringResource(id = resId), color = Color.Blue)
}

@Composable
fun sizeText(resId: Int) {
    Text(stringResource(id = resId), fontSize = 30.sp)
}

/***
 * 设置文字是正常体或者是斜体
 */
@Composable
fun styleText(resId: Int) {
    Text(stringResource(id = resId), fontStyle = FontStyle.Italic)
}

/***
 * 设置文本的子重
 */
@Composable
fun weightText(resId: Int) {
    Text(stringResource(id = resId), fontWeight = FontWeight.Bold)
}

/***
 * 设置文本的对齐方式
 */
@Composable
fun alignText(resId: Int) {
    Text(

        stringResource(id = resId),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .width(200.dp)
            .background(Color.Blue)
    )
}

@Composable
fun diffFont(resId: Int) {
    Text(stringResource(id = resId), fontFamily = FontFamily.Serif)
}

/***
 * 自定义字体样式
 */
@Composable
fun myselfStyleFont(resId: Int) {
    val firstFamily = FontFamily(Font(R.font.alibaba_puhui_bold, FontWeight.Bold))
    Text(stringResource(id = resId), fontFamily = firstFamily)
}


@Composable
fun mutableStyleIntText(resId: Int) {
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("H")
        }
        append("ello ")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
            append("W")
        }
        append("orld")
    })
}

@Composable
fun paragraphStyle() {
    Text(buildAnnotatedString {
        withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("Hello\n")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            ) {
                append("World\n")
            }
            append("Compose")
        }
    })
}


@Composable
fun maxLineText() {
    Text("Hello".repeat(50), maxLines = 2)
}

@Composable
fun maxCountText() {
    Text("Hello".repeat(60), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Composable
fun selectText(resId: Int) {
    SelectionContainer {
        Text(stringResource(id = resId))
    }
}

/***
 * 获取点击的位置 可以对不同的位置点击做不同的效果
 */
@Composable
fun SimpleClickableText(context: Context) {
    ClickableText(text = AnnotatedString("Click me"), onClick = {
        Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
    })

}

@Composable
fun simpleFilledTextFieldSample() {
    var text by remember {
        mutableStateOf("Hello")
    }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("label") })
}

@Composable
fun simpleOutlineTextFieldSample() {
    var text by remember {
        mutableStateOf("hint ")

    }
    OutlinedTextField(value = text, onValueChange = {
        text = it
    }, label = { Text(text = "label") })
}



