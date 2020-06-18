package kulloveth.developer.com.countrydetails.data.model

import java.io.Serializable

data class Currency(
    val code: String,
    val name: String, val symbol: String
) : Serializable