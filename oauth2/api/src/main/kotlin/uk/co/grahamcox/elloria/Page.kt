package uk.co.grahamcox.elloria

/**
 * Representation of a page of results
 * @property entries The entries on the page
 * @property totalEntries The total number of entries
 */
data class Page<T>(val entries: List<T>,
                   val totalEntries: Int) {
    /**
     * Convert a page of entries of one type into a page of entries of a different type
     * @param transform The transformation function
     * @return the new page
     */
    fun <R> map(transform: (T) -> R): Page<R> = Page(entries.map(transform), totalEntries)
}