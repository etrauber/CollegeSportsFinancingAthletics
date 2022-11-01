# Exploring Factors That Affect The Financing Of College Sports

## Introduction
- To explore the question of what factors effect the financing of college sports, I decided to look into some key elements that are unique to every university, including tuition, athletic conferences, and endowments. This topic is particularly interesting to me as it combines my two of my main interests in life, which are athletics and statstics. I have played sports since I was young and playing college sports has always been a dream of mine. As it is coming true next year, it is becoming more important to me to learn about athletics programs at univisities, especially state schools that don't appear to have as much money as private universities, yet somehow generate massive atheltic departments. 

## Questions I am answering
1. Does a school’s tuition directly correlate to how much money they pour into their athletics programs? 
2. What conferences have the highest average support, and what conferences have the lowest? Does this follow my prediction that leagues with better ranked teams will have more money?
3. How largely do endowments contribute to the money given to the athletics of a school? 

## Theories/Predictions
1. For my first question surronding the correlation between the instate tuition of a school and the funding of their athletic departments, I predicted that these two pieces of data would be unrelated. As a result, it will have a semi-low correlation coefficient, as I do not think tuition would have a big factor in funding a school athletics. My logic behind this is that the majority of these schools are state funded and so tuition from students would not signficantly impact the money given to athletics. 
2. For my second question about if the conferences a team is a part of will impact the amount of money the athletic departments will recieve on average, I predict that it will affect it. I predict that conferences with better ranking teams will, on average, give more funding to their athletic departments, because these athletics will make the school itself more money as well. This can be seen by comparing a conference like the Southeastern Conference, which contains teams like Alabama and Auburn, to the Sunbelt conference, which contains teams like Arkansas State and Costal Carolina. I am predicting that the Southereastern Conference will have a higher average support than the Sunbelt conference for example as Alambama and Auburn tend to have teams with higher rankings than Arkansas State and Costal Carolina, and subsequently more people will want to watch. If more people watch the games, the school will make more money from them, and as a result will pour more money into their athletics departments. 
3. For my third question about if endowments will contribute to the money given to the athletics of a school, I predict that it will have an impact. I predicted that endowments and funding would be closley correlated because I think that if a school has a greater endowment, they will have more money available to pour into their athletics.   

## Dataset Source
The data contained within this set includes the revenues/expenditures of over 234 Division I public universities. It attempts to explain the ways in which these schools pay for their large athletics programs, by showing the breakdown of finances of each school. The dataset comes from the collaboration between The Huffington Post and The Chronicle of Higher Education, which has covered the crossroads between college sports and academia for many years. I have permission to use this dataset from the owner because in the article that was written preceding the data, the author wrote that he encourages everyone to look at the data in order to tell their own stories about college sports subsidies, and the things that colleges give up to further their athletic programs.  

## Methods
I used three main methods in order to answer my three preliminary questions, each method directly correspodning to a question. As well, I used various helper methods in my program in order to make my code more general and conscice. The methods I used to answer my research questions are the following: 
1. To investigate how a school’s tuition affects the money given to their athletic programs, I create a function to look at both the instate tuition (as all schools on the list are state-schools) and the money given to the athletics programs and generate a correlation coefficient to determine how closely linked these two pieces of data are. To do this, I generated a list of the schools' instate tuition and compared it to a list of the the funding of the schools athletics programs, which I was able to obtain using the dataset. Then, using these two lists, I used a helper method I created to generate the correlation coefficient, using this formula... This allowed me to determine overall how closely correlated tuition and funding are. 
2. To investigate how a conference affects the money given to the athletics programs, I created a method to find the average funding a schools give to their athletic departments for each specific conference. I then put those values into a list in order to print them out and look at them to compare them to each other. In order to do this, I determined which conferecence each school is a part of, and the athletic funding each school is given. I then created a list of averages, each index representing each conference. With this, I am able to manually look at each conference's average funding and determine if there is a trend, if there is really a correlation between the rankings of the schools that a conference encompasses and the average funding of those conferences as I suspected. 
3. To investigate how endowments affect the money given to athletic teams, I did a very similar thing as I did to determine the correlation between tuition and funding. To do this, I generated a list of the schools' endowments and compared it to a list of the the funding of the schools athletics programs, which I was able to obtain using the dataset. Then, using these two lists, I used a helper method I created to generate the correlation coefficient, which allowed me to determine overall how closely correlated endowments and funding are.
- Finally, I created two helper methods, one of which generated the mean of all the values of an arraylist. The second helper method I created generated the correlation coefficient as I needed that number in multiple places in my code. I made these two helper methods to make these two mathematical equations/steps reusable as I was able to call the methods in various places in my code (specifically to answer questions 1 and 3). 

- Throughout this project, I faced a many minor setback, however I also faced on major setback. The biggest setback I faced was determining a way to take the data I generated for instate tuition and comparing it to the data of funding per school and determine a relationship. I was able to come up with both a list of the tuition of each school and a list of the funding of each school, however, with so many schools, I needed to find a way to generate a singular number, or at least fewer numbers to look at. In order to overcome this, I was able to use the correlation coefficient, which allowed me to determine that tuition and funding are # correlated. I was also able to use this to overcome this same problem that arose in my endowments in relation to funding issue. 

## Results and Conclusions
### Results
The code I used to investigate my three preliminary questions proved very helpful. 
    - My first question, which was "Does a school’s tuition directly correlate to how much money they pour into their athletics programs?" was able to be answered by through the method I create to sift through this portion of my dataset. I generated a correlation coefficent to determine how closely correlated instate tuition and the funding of athletics programs are. My results proved my predictions to be true. I generated a correlation coefficient of -0.14693894407820607, which indicates that tuition and funding are uncorrelated, and if anything have a very slight negative correlation. This shows that as funding of a school increases, the tuition has a tendency to slightly lower (however not by large margins).

    - My second question, which is "What conferences have the highest average support, and what conferences have the lowest? Does this follow my prediction that leagues with better ranked teams will have more money?" was also able to be answered using the method I created. 

    - My third question, which was "How largely do endowments contribute to the money given to the athletics of a school? " was also answered by the program I created. By using the correlation coefficient, similar to what I did for comparing tuition to funding, to compare total endowments of a school to total funding given to a school's athletic department, I was able to determine that my prediction was false. This is because my correlation coefficient came out to be -0.2392447619194788, which indicated that endowments and funding of athletics are in fact not closely correlated. If a schools endowments increased, the funding of their athletics deapartments actually have a trend of decreasing slightly. However, because the correlation coefficient is very minor at only -.2 and not -.9, it shows that these two factors are essentially not correlated, as if the coefficient was -.9 they would be almost perfectly negativley correlated (this means that as one increases, the other would almost proportionally decrease). The reasons for this could be that because these schools are funded by their states, the endowments they have may not go towards athletics, and instead may go towards furthering their research or academics. 

## Further things I could investigate
If I had more time, there are countless other things I could investigate when it comes to the financing of college athletics. One thing I would want to look into is if rankings of big sports teams, including football, basketball, and baseball, impact the amount of money athletic departments get. As well, I think it would be very interesting to see the breakdown of funding per sport at each school, rather than just for the athletics overall. Finally, I think it would be very interesting to look at the money that are put into athletics at universities in the United States in comparison to aborad, as I predict that US would have a signficantly higher funding for sports as athletics are given a big emphasis in America, in contrast to other parts of the world.