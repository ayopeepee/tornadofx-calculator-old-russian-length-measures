package com.example.demo.view

import javafx.geometry.NodeOrientation
import javafx.geometry.Pos
import net.objecthunter.exp4j.ExpressionBuilder
import javafx.scene.control.TextField
import javafx.scene.control.Label
import javafx.scene.paint.Color
import tornadofx.*
import javafx.scene.text.FontWeight

import tornadofx.*

class MainView : View("Calculator") {
    private val inputField = TextField().apply {
        isEditable = false
        alignment = Pos.BASELINE_RIGHT
        style {
            backgroundColor += Color.TRANSPARENT
            fontSize = 40.px
            textFill = Color.WHITE
            alignment = Pos.CENTER_RIGHT
        }
    }
    private val resultLabel = Label().apply {
        style {
            backgroundColor += Color.TRANSPARENT
            fontSize = 20.px
            textFill = Color.GRAY
            alignment = Pos.BASELINE_RIGHT
            paddingRight = 10
        }
    }
    override val root = vbox(10) {
        paddingAll = 10
        style {
            backgroundColor += Color.web("#000000")
        }
        add(inputField)
        add(resultLabel)

        gridpane {
            hgap = 50.0
            vgap = 50.0

            // Add number buttons

            button("T") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(1, 4) }
            button("L") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(0, 3) }
            button("S") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(1, 3) }
            button("Vk") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(2, 3) }
            button("P") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(0, 2) }
            button("A") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(1, 2) }
            button("Sa") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(2, 2) }
            button("Ve") { action { inputField.text += text }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#353535")
                    borderColor += box(Color.web("#2E2E2E"))
                }}.gridpaneConstraints { columnRowIndex(0, 4) }
            // Add operation buttons
            button("+") { action { addToInput(text) }
                style {
                    fontSize = 30.px
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }}.gridpaneConstraints { columnRowIndex(3, 1) }
            button("-") { action { addToInput(text) }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }}.gridpaneConstraints { columnRowIndex(3, 2) }
            button("*") { action { addToInput(text) }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }}.gridpaneConstraints { columnRowIndex(3, 3) }
            button("/") { action { addToInput(text) }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }}.gridpaneConstraints { columnRowIndex(3, 4) }

            // Add equals and clear buttons
            button("=") {
                action {
                    try {
                        resultLabel.text = eval(inputField.text).toString()
                    } catch (e: Exception) {
                        resultLabel.text = "Error"
                    }
                }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }
            }.gridpaneConstraints { columnRowIndex(2, 4) }

            button("C") {
                action {
                    inputField.text = ""
                    resultLabel.text = ""
                }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }
            }.gridpaneConstraints { columnRowIndex(0, 1) }

            button("⌫") {
                action {
                    inputField.text = inputField.text.replaceFirst(".$".toRegex(), "")
                }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }
            }.gridpaneConstraints { columnRowIndex(1, 1) }

            button("<->") {
                action {
                    resultLabel.text = if (Regex("\\d").containsMatchIn(resultLabel.text)) {
                        convertToOldRussianUnits(resultLabel.text)
                    } else {
                        convertFromOldRussianUnits(resultLabel.text).toString()
                    }
                }
                style {
                    fontSize = 30.px
                    fontWeight = FontWeight.BOLD
                    textFill = Color.WHITE
                    backgroundColor += Color.web("#FF9500")
                    borderColor += box(Color.web("#E88100"))
                }
            }.gridpaneConstraints { columnRowIndex(2, 1) }
        }
    }

    private fun addToInput(text: String) {
        inputField.text += text
    }

    private fun eval(expression: String): Double {
        val numberExpression = expression.replace("T","0.000254")
            .replace("L", "0.00254").replace("S", "0.021336")
            .replace("Vk", "0.04445").replace("P", "0.1778")
            .replace("A", "0.7112").replace("Sa", "2.1336")
            .replace("Ve", "1066.8")
        // Evaluate the expression using exp4j library
        return try {
            val result = ExpressionBuilder(numberExpression).build().evaluate()
            result
        } catch (e: Exception) {
            throw IllegalArgumentException("Invalid expression")
        }
    }
}



fun convertToOldRussianUnits(numberAsString: String): String {
    val units = mapOf(
        "Ve" to 1066.8,
        "Sa" to 2.1336,
        "A" to 0.7112,
        "P" to 0.1778,
        "Vk" to 0.04445,
        "S" to 0.021336,
        "L" to 0.00254,
        "T" to 0.000254
    )

    val number = numberAsString.toDouble()
    val orderedUnits = units.entries.sortedByDescending { it.value }


    var remainingNumber = number
    val oldRussianUnits = StringBuilder()
    for (unit in orderedUnits) {
        val unitCount = (remainingNumber / unit.value).toInt()
        if (unitCount > 0) {
            oldRussianUnits.append(unit.key.repeat(unitCount))
            remainingNumber -= unitCount * unit.value
        }
    }
    return oldRussianUnits.toString()
}

fun convertFromOldRussianUnits(oldRussianUnits: String): Double {
    val units = mapOf(
        "Ve" to 1066.8,
        "Sa" to 2.1336,
        "A" to 0.7112,
        "P" to 0.1778,
        "Vk" to 0.04445,
        "S" to 0.021336,
        "L" to 0.00254,
        "T" to 0.000254
    )

    var remainingUnits = oldRussianUnits
    var result = 0.0
    for (unit in units) {
        val unitCount = remainingUnits.count { it.toString() == unit.key }
        if (unitCount > 0) {
            result += unit.value * unitCount
            remainingUnits = remainingUnits.replace(unit.key, "")
        }
    }
    return result
}

