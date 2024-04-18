# An API Supervisory
    This application has a target to creat an API which contains CRUDS methods to persist datas in MySQL database. This 
application is a part of the Supervisory Project, like an industrial application, having a layout where the machines are
installed forming a industrial process. In it, there is a system of detection, for example, is this supervisory 
application, it is an ammonia detection system.
    So, each detector has its own configuration, like range of detection, serial number, tag, name, local place 
installed, date of the last calibration and the date of the next calibration. This project is following concepts as a 
real application, which provides resources to manage and traceability. Rules to manage are considered as an hierarchy, 
being possible only manager or supervisor profiles can create new users and delete registers in the database.
    Through set point in the modal of each detector config, this feature will be able in the frontend application, so
above this set point, the detector will start some registering event, having registered the high value hit, including
its date and hour of occurrence. All these registers will be accessible in table forms and, the user can build like 
dashboard to analyze the most points of leak and their treatment.
