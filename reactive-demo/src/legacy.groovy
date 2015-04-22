/**
 * Created by mohan on 3/30/15.
 */

println "******* Legacy -- Start Program *******"

long start = System.currentTimeMillis()

fetchWikipediaLegacy("Tiger", "Elephant", "Horse", "Lion", "Cat", "Dog")

println "-------------------------------------"
println "Time " + (System.currentTimeMillis() - start)
println "-------------------------------------"

println "******* Legacy -- End Program *******"


def fetchWikipediaLegacy(String ... articleNames) {
    for(articleName in articleNames){
        def response = new URL("http://en.wikipedia.org/wiki/"+articleName).getText();
        println "reponse -> ${response.substring(0,125)}"
    }
}