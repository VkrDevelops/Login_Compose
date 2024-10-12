package com.vkr.simpleloginbywaqar.data

import androidx.annotation.EmptySuper
import com.google.gson.annotations.SerializedName

data class Data(
    val problems: MutableList<Problem>? = mutableListOf()
)

data class ClassName(
    val associatedDrug: List<AssociatedDrug>,
    @SerializedName("associatedDrug#2")
    val associatedDrug2: List<AssociatedDrug>
)

data class Asthma(val emptySuper: EmptySuper)


data class AssociatedDrug(
    val dose: String? = "",
    val name: String? = "",
    val strength: String? = ""
)

data class Diabetes(
    val labs: MutableList<Lab>? = mutableListOf(),
    val medications: MutableList<Medication>? = mutableListOf()
)

data class Lab(
    val missing_field: String? = ""
)

data class Medication(
    val medicationsClasses: MutableList<MedicationsClasses>? = mutableListOf()
)

data class MedicationsClasses(
    val className: MutableList<ClassName>? = mutableListOf(),
    val className2: MutableList<ClassName>? = mutableListOf()
)

data class Problem(
    val Asthma: MutableList<Asthma>? = mutableListOf(),
    val Diabetes: MutableList<Diabetes>? = mutableListOf()
)