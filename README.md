Ok guys, here's what I did (might not be the best solution since this is my first webcrawler):

I created my crawler class which has a crawl method, the crawl method receives a String called
"seed" as a parameter.

It checks if this url has been already visited (I keep a set with all the visited urls)
and if it hasn't, it saves it as visited and then calls crawl recursively (i saw this can be done with a regular list and not recursively but decided to do this to keep it interesting).

I used a library called Jsoup which facilitates the parsing part (i could have done this with plain html strings, but it would have been a lot of extra unnecessary work).

So i get the list of link elements from the DOM of the current seed, and recursively call crawl again
for all the links found.

To check if it's not external page, I created a simple method that checks if the url contains the main domain that we searched for. This is a pretty simple method, and it could be improved as to tackle any other problems that it might have.

How to run:
You just need to execute the main method, you can do this from console, or importing the project from eclipse and just hit run. (Please be aware that this could actually receive the url as a parameter from console, but I just wanted to keep things simple, it should work with any valid url given anyhow).

