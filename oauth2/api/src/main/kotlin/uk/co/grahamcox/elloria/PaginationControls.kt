package uk.co.grahamcox.elloria

/**
 * Controls for requesting a page of results
 * @property offset The offset to request
 * @property limit The limit of records to return
 */
data class PaginationControls(val offset: Int = 0,
                              val limit: Int = 10)