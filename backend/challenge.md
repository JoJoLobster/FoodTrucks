# Challenge Guidelines
This is meant to be an assignment that you spend approximately two to three hours of focused coding. Do not feel that you need to spend extra time to make a good impression. Smaller amounts of high quality code will let us have a much better conversation than large amounts of low quality code.

Think of this like an open source project. Create a repo on Github, use git for source control, and use a Readme file to document what you built for the newcomer to your project.

We build systems engineered to run in production. Given this, please organize, design, test, deploy, and document your solution as if you were going to put it into production. We completely understand this might mean you can't do much in the time budget. Prioritize production-readiness over features.

Think out loud in your documentation. Write our tradeoffs, the thoughts behind your choices, or things you would do or do differently if you were able to spend more time on the project or do it a second time.

Please use spring framework & java 8+, docker is preferred. Make sure to <font color="#dd0000">**document how to get started with your solution**</font> in terms of setup so that we'd be able to run it.


Once this is functioning and documented to your liking, either send us a link to your public repo or compress the project directory, give the file a pithy name which includes your own name, and send the file to us.


# The Challenge
As the song says, "you've got to play the hand you're dealt", and in this case your hand is to implement something to help us manage our food truck habit.

Our team loves to eat. They are also a team that loves variety, so they also like to discover new places to eat.

In fact, we have a particular affection for food trucks. One of the great things about Food Trucks in San Francisco is that the city releases a list of them as open data.

Your assignment is to make it possible for our teams to do something interesting with this food trucks data.

This is a freeform assignment.
> 1. You can write a web API that returns a set of food trucks.
> 2. You can write a web frontend that visualizes the nearby food trucks for a given place. 
> 3. You can create a CLI that lets us get the names of all the taco trucks in the city.
> 4. You can create system that spits out a container with a placeholder webpage featuring the name of each food truck to help their marketing efforts. 
> 5. Any idea is welcome

You're not limited by these ideas at all, but hopefully those are enough help spark your own creativity. San Francisco's food truck open dataset is [located here](https://data.sfgov.org/Economy-and-Community/Mobile-Food-Facility-Permit/rqzj-sfat/data) and there is an endpoint with a [CSV dump of the latest data here](https://data.sfgov.org/api/views/rqzj-sfat/rows.csv). We've also included a copy of the data in the folder as well.