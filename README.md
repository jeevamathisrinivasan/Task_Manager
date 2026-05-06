## Setup Instructions

### 1️ Clone or Import Project

git clone https://github.com/jeevamathisrinivasan/Task_Manager.git

OR import into Eclipse:

File → Import → Existing Maven/Java Project

- Run in Eclipse
- Open project in Eclipse
- Go to Main.java
- Right click → Run As → Java Application
- Console menu will start

---


##  Assumptions

- Each task has a unique taskId  
- Task initially starts in PENDING state  
- Two worker threads process tasks simultaneously  
- Task processing time is simulated using Thread.sleep()  
- Linked list is the main data storage (no Java Collections used)  

##  Limitations

- Console-based application (no UI)  
- No persistent storage (data resets after program exit)  
- No database integration  
- No real-time dashboard or reporting  
- Basic thread simulation only (not production-level scheduling) 


##  Known Issues

- If multiple threads run, output order may vary (due to thread scheduling)  
- Reverse operation changes original list order permanently  
- No input validation for incorrect task status/priority values  
