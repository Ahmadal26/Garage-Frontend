package com.joincoded.bankapi.data

import com.joincoded.bankapi.R
import com.joincoded.bankapi.model.GarageBranch
import com.joincoded.bankapi.model.Type

class GarageRepo {
    companion object {
        val garageList = listOf<GarageBranch>(
            GarageBranch(
                1, "Shwiakh", Type.US,
                "Near the Co-Op", "97434111",
                "9:00 -5:00",
                "https://www.google.com/maps/place/%D8%A8%D9%8A%D8%AA+%D8%A7%D9%84%D8%AA%D9%85%D9%88%D9%8A%D9%84+%D8%A7%D9%84%D9%83%D9%88%D9%8A%D8%AA%D9%8A+-+%D9%81%D8%B1%D8%B9+%D8%A7%D9%84%D8%AE%D8%A7%D9%84%D8%AF%D9%8A%D8%A9%E2%80%AD/@29.328966,47.964459,15z/data=!4m2!3m1!1s0x0:0x90397b151c0c8a59?sa=X&ved=2ahUKEwibxeeCi_aDAxXd9gIHHQjRBRkQ_BJ6BAhOEAA",
                R.drawable.orp,
                reviews = "Good Place"
            ),
            GarageBranch(
                2, "Pro Rider", Type.GERMAN,
                " Sports Club", "457353998",
                "9:00 - 5:00",
                "https://www.google.com/maps/place/%D8%A8%D9%8A%D8%AA+%D8%A7%D9%84%D8%AA%D9%85%D9%88%D9%8A%D9%84+%D8%A7%D9%84%D9%83%D9%88%D9%8A%D8%AA%D9%8A+-+%D9%81%D8%B1%D8%B9+%D9%83%D9%8A%D9%81%D8%A7%D9%86%E2%80%AD/@29.3395215,47.9619357,15z/data=!4m2!3m1!1s0x0:0x36b176ac874f5049?sa=X&ved=2ahUKEwjBoMfCi_aDAxUA8gIHHQssAs0Q_BJ6BAhREAA",
                R.drawable.ko,
                reviews = "Good Place"

            ),
            GarageBranch(
                3, "AlYarmouk Branch", Type.US,
                "AlYarmouk, at the back of the KNPC gas station", "+965 24698716",
                "9:00 - 5:00",
                "https://www.google.com/maps/place/%D8%A8%D9%8A%D8%AA+%D8%A7%D9%84%D8%AA%D9%85%D9%88%D9%8A%D9%84+%D8%A7%D9%84%D9%83%D9%88%D9%8A%D8%AA%D9%8A%E2%80%AD/@29.3094936,47.9634681,3a,75y,90t/data=!3m8!1e2!3m6!1sAF1QipPVp2Rf_k0wlEyOqyRv-2xjN-y87aE__j1sKOL6!2e10!3e12!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPVp2Rf_k0wlEyOqyRv-2xjN-y87aE__j1sKOL6%3Dw114-h86-k-no!7i3648!8i2736!4m15!1m7!3m6!1s0x3fcf9ba83373d7f5:0xee024ddfe2ddc380!2z2KjZitiqINin2YTYqtmF2YjZitmEINin2YTZg9mI2YrYqtmK!8m2!3d29.3094927!4d47.9634976!16s%2Fg%2F1x5f8vfl!3m6!1s0x3fcf9ba83373d7f5:0xee024ddfe2ddc380!8m2!3d29.3094927!4d47.9634976!10e5!16s%2Fg%2F1x5f8vfl?entry=ttu",
                R.drawable.okj,
                reviews = "Good Place"

            ),
            GarageBranch(
                4, "Shawikh industruial", Type.GERMAN,
                "mina shwaikh", "993354576",
                "9:00 - 5:00",
                "https://www.google.com/maps/place/%D8%A8%D9%8A%D8%AA+%D8%A7%D9%84%D8%AA%D9%85%D9%88%D9%8A%D9%84+%D8%A7%D9%84%D9%83%D9%88%D9%8A%D8%AA%D9%8A+-+%D9%81%D8%B1%D8%B9+%D8%A7%D9%84%D8%AE%D8%A7%D9%84%D8%AF%D9%8A%D8%A9%E2%80%AD/@29.328966,47.964459,15z/data=!4m2!3m1!1s0x0:0x90397b151c0c8a59?sa=X&ved=2ahUKEwibxeeCi_aDAxXd9gIHHQjRBRkQ_BJ6BAhOEAA",
                R.drawable.ooo,
                reviews = "Good Place"

            ),
            GarageBranch(
                5, "Shawikh industruial", Type.GERMAN,
                "mina shwaikh", "993354576",
                "9:00 - 5:00",
                "https://www.google.com/maps/place/%D8%A8%D9%8A%D8%AA+%D8%A7%D9%84%D8%AA%D9%85%D9%88%D9%8A%D9%84+%D8%A7%D9%84%D9%83%D9%88%D9%8A%D8%AA%D9%8A+-+%D9%81%D8%B1%D8%B9+%D8%A7%D9%84%D8%AE%D8%A7%D9%84%D8%AF%D9%8A%D8%A9%E2%80%AD/@29.328966,47.964459,15z/data=!4m2!3m1!1s0x0:0x90397b151c0c8a59?sa=X&ved=2ahUKEwibxeeCi_aDAxXd9gIHHQjRBRkQ_BJ6BAhOEAA",
                R.drawable.ko,
                reviews = "Good Place"

            ),
            GarageBranch(
                6, "Shawikh industruial", Type.GERMAN,
                "mina shwaikh", "993354576",
                "9:00 - 5:00",
                "https://www.google.com/maps/place/%D8%A8%D9%8A%D8%AA+%D8%A7%D9%84%D8%AA%D9%85%D9%88%D9%8A%D9%84+%D8%A7%D9%84%D9%83%D9%88%D9%8A%D8%AA%D9%8A+-+%D9%81%D8%B1%D8%B9+%D8%A7%D9%84%D8%AE%D8%A7%D9%84%D8%AF%D9%8A%D8%A9%E2%80%AD/@29.328966,47.964459,15z/data=!4m2!3m1!1s0x0:0x90397b151c0c8a59?sa=X&ved=2ahUKEwibxeeCi_aDAxXd9gIHHQjRBRkQ_BJ6BAhOEAA",
                R.drawable.ooo,
                reviews = "Good Place"

            ),
            GarageBranch(
                7, "Shawikh industruial", Type.GERMAN,
                "mina shwaikh", "993354576",
                "9:00 - 5:00",
                "https://www.google.com/maps/place/%D8%A8%D9%8A%D8%AA+%D8%A7%D9%84%D8%AA%D9%85%D9%88%D9%8A%D9%84+%D8%A7%D9%84%D9%83%D9%88%D9%8A%D8%AA%D9%8A+-+%D9%81%D8%B1%D8%B9+%D8%A7%D9%84%D8%AE%D8%A7%D9%84%D8%AF%D9%8A%D8%A9%E2%80%AD/@29.328966,47.964459,15z/data=!4m2!3m1!1s0x0:0x90397b151c0c8a59?sa=X&ved=2ahUKEwibxeeCi_aDAxXd9gIHHQjRBRkQ_BJ6BAhOEAA",
                R.drawable.orp,
                reviews = "Good Place"

            ),

            )
    }
}