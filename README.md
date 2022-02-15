A Java app, hosted on Heroku: [CoronaVirusTracker](https://heroku-boot-coronavirustracker.herokuapp.com/)

## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```sh
$ git clone https://github.com/Gjonathan252/heroku-boot-coronavirustracker.git
$ cd heroku-boot-coronavirustracker
$ mvn install
$ heroku local:start
```
Your app should now be running on [localhost:5000](http://localhost:5000/).


# CoronaVirusTracker Documentation 
CoronaVirusTracker application is hosted on Heroku. Using SpringBoot initializer and Heroku to live host the website. The application remains a work in progress with new features and more information soon to be added. 
The application provides the most recent corona virus updates provided by Center for Systems Science and Engineering (CSSE) at Johns Hopkins University public 
[Repository](https://github.com/CSSEGISandData/COVID-19). Running the website initalized the springboot application and loads the most recent data provided. 


### What needs to change
Everytime the application is ran a new data pull is raned and converted. If a large group was to use this application at the same time it can cause errors and failuers. What should be done is remotly saving statically the data once a day. This way the data is not pulled everytime the data is ran. Just reference from the static data daily. This can be done by having a master/dev version which runs every hour or day and changes a static file to the data it pulled. Then when the user runs the application it is only loading the static version of the website without needing to pull the data everytime. 


![Alt text](https://i.imgur.com/ErmhAkV.png)


** This application is not intended to provide information. It is intended to demonstrate proof of work. I dont have authorization to use the data provided. This application is not maintained and can provide errors live data. The application should not be used for information. **
