fun main() {
    print(stringsRearrangement(mutableListOf("aba","bbb","bab")))
}

fun stringsRearrangement(inputArray: MutableList<String>): Boolean {

    var m= inputArray.permutations()

    for(i in 0 until m.size)
        if(stringChecker(m[i]))
            return true
    
    return false
}

fun <V> List<V>.permutations(): List<List<V>> {
    val retVal: MutableList<List<V>> = mutableListOf()

    fun generate(k: Int, list: List<V>) {
        // If only 1 element, just output the array
        if (k == 1) {
            retVal.add(list.toList())
        } else {
            for (i in 0 until k) {
                generate(k - 1, list)
                if (k % 2 == 0) {
                    java.util.Collections.swap(list, i, k - 1)
                } else {
                    java.util.Collections.swap(list, 0, k - 1)
                }
            }
        }
    }

    generate(this.count(), this.toList())
    return retVal
}

fun stringChecker(mlist:List<String>):Boolean{
    var myCount=0
    for(i in 1 until mlist.size){
        var count=0
        if(mlist[i-1].length==mlist[i].length){
            for(j in 0 until mlist[i].length){
                if(mlist[i][j]!=mlist[i-1][j])
                    count++
            }

        }
        if(count>1)
            return false
        if(count==1)
            myCount+=count
    }
    if(myCount==mlist.size-1)
        return true
    else
        return false

}
