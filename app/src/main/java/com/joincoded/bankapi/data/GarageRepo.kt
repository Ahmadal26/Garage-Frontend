package com.joincoded.bankapi.data

import com.joincoded.bankapi.R
import com.joincoded.bankapi.model.GarageBranch
import com.joincoded.bankapi.model.Type

class GarageRepo {
    companion object {
        val garageList = listOf<GarageBranch>(
            GarageBranch(
                1, "ORP", Type.US,
                "Shuwaikh Industrial", "1886888",
                "9:00 -5:00",
"https://maps.app.goo.gl/83tUp3kU9LWfySVS9",
                R.drawable.orp,
                reviews = "Good Place"
            ),
            GarageBranch(
                2, " Al-Mailam ", Type.GERMAN,
                "Canada Dry Street", "1884737",
                "9:00 - 5:00",
"https://maps.app.goo.gl/46fSitXiDNo5XYF47",
                R.drawable.unnamed,
                reviews = "Good Place"

            ),
            GarageBranch(
                3, "UNDERGROUND RACING -UGR", Type.US,
                "Shuwaikh Industrial", "+965 96633300",
                "9:00 - 5:00",
"https://maps.app.goo.gl/PgFzTimZBiTcymPJ9",
                R.drawable.ugr,
                reviews = "Good Place"

            ),
            GarageBranch(
                4, "N.S.P", Type.GERMAN,
                "Canada Dry", "24830904",
                "9:00 - 5:00",
"https://maps.app.goo.gl/kgBxHB5BjrUt7TNHA",
                R.drawable.alghannam,
                reviews = "Good Place"

            ),
            GarageBranch(
                5, "AlBabtain Auto Canada Dry Street", Type.GERMAN,
                "Canada Dry Street", "1822500",
                "9:00 - 5:00",
"https://maps.app.goo.gl/9mTqjgHX9iJXuMPB6",
                R.drawable.albabtain,
                reviews = "Good Place"

            ),
            )
    }
}