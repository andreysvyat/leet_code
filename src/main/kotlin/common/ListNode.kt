package common

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    constructor(`val`: Int, next: ListNode): this(`val`) {
        this.next = next
    }

    override fun toString(): String {
        var curr = this
        var str = curr.`val`.toString()
        while (curr.next != null) {
            str += "->${curr.next?.`val`}"
            curr = curr.next!!
        }
        return str
    }

    override fun equals(other: Any?): Boolean {
        // Проверка на идентичность ссылок
        if (this === other) return true

        // Проверка на null
        if (other == null) return false

        // Проверка на совпадение классов
        if (this::class != other::class) return false

        // Приведение типа
        other as ListNode

        // Сравнение значений текущего узла
        if (`val` != other.`val`) return false

        // Рекурсивное сравнение следующих узлов
        return when {
            next == null && other.next == null -> true
            next != null && other.next != null -> next == other.next
            else -> false
        }
    }

    override fun hashCode(): Int {return `val`.hashCode()}
}