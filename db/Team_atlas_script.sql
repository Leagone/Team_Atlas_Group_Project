-- SQL Script to create and populate table

-- Drop tables if they exist
DROP TABLE IF EXISTS UserConversationInteraction;
DROP TABLE IF EXISTS UserActivity;
DROP TABLE IF EXISTS Conversations;
DROP TABLE IF EXISTS RegularUser;
DROP TABLE IF EXISTS Administrator;
DROP TABLE IF EXISTS Lang;
DROP TABLE IF EXISTS Levels;
DROP TABLE IF EXISTS Context;
DROP TABLE IF EXISTS SubContext;


-- Create RegularUser table
CREATE TABLE RegularUser
(
    EmailAddress VARCHAR(99),
    Pass VARCHAR(99) NOT NULL,
    UserID INTEGER UNIQUE NOT NULL,
    FirstName VARCHAR(99) NOT NULL,
    LastName VARCHAR(99) NOT NULL,
    IsTeacher BOOLEAN NOT NULL,
    constraint email_pk PRIMARY KEY (EmailAddress)
);

-- Create Administrator table
CREATE TABLE Administrator
(
    EmailAddress VARCHAR(99),
    Pass VARCHAR(99) NOT NULL,
    AdminID INTEGER UNIQUE NOT NULL,
    constraint email_pk PRIMARY KEY (EmailAddress)
);


-- Create Languages table
CREATE TABLE Lang
(
    languageID VARCHAR(99),
    lang VARCHAR(99) NOT NULL,
    constraint languageID_pk PRIMARY KEY (languageID)
);

-- Create Level table
CREATE TABLE Levels
(
    levelID VARCHAR(99),
    Lvl VARCHAR(99) NOT NULL,
    constraint levelID_pk PRIMARY KEY (levelID)
);
-- Create Context table
CREATE TABLE Context
(
    ContextID VARCHAR(99),
    Context VARCHAR(99) NOT NULL,
    constraint ContextID_pk PRIMARY KEY (ContextID)
);
-- Create SubContext table
CREATE TABLE SubContext 
(
    SubContextID VARCHAR(99),
    SubContext  VARCHAR(99) NOT NULL,
    constraint SubContextID_pk PRIMARY KEY (SubContextID)
);

-- Create Conversations table
CREATE TABLE Conversations
(
    ConversationID VARCHAR(99),
    Grammar VARCHAR(99),
    PersonAText VARCHAR(10000) NOT NULL,
    PersonBText VARCHAR(10000) NOT NULL,
    languageID VARCHAR(99) NOT NULL,
    levelID VARCHAR(99) NOT NULL,
    ContextID VARCHAR(99) NOT NULL,
    SubContextID VARCHAR(99) NOT NULL,

    constraint convID_pk PRIMARY KEY (ConversationID),
    constraint languageID_pk FOREIGN KEY (languageID) references Lang(languageID),
    constraint levelID_pk FOREIGN KEY (levelID) references Levels(levelID),
    constraint ContextID_pk FOREIGN KEY (ContextID) references Context(ContextID),
    constraint SubContextID_pk FOREIGN KEY (SubContextID) references SubContext(SubContextID)
);

-- Create UserActivity table
CREATE TABLE UserActivity 
(
    activityID VARCHAR(99),
    loginTimestamp DATETIME NOT NULL,
    logoutTimestam DATETIME NOT NULL,
    EmailAddress VARCHAR(99) NOT NULL,
    constraint activityID_pk PRIMARY KEY (activityID),
    constraint UserEmail_pk FOREIGN KEY (EmailAddress) references RegularUser(EmailAddress),
    constraint AdminEmail_pk FOREIGN KEY (EmailAddress) references Administrator(EmailAddress)
);

-- Create User_Conversation_Interaction
CREATE TABLE UserConversationInteraction
(
    EmailAddress VARCHAR(99),
    ConversationID VARCHAR(99) NOT NULL,
    pairID VARCHAR(99) NOT NULL,
    interactionDateAndTime DATETIME NOT NULL,
    NumOfHintsUSed INTEGER NOT NULL,
    ConversationCompleted BOOLEAN NOT NULL,
    constraint interactionID_pk PRIMARY KEY (EmailAddress, ConversationID, pairID, interactionDateAndTime),
    constraint InteractionUserEmail_pk FOREIGN KEY (EmailAddress) references RegularUser(EmailAddress),
    constraint ConversationID_pk FOREIGN KEY (ConversationID) references Conversations(ConversationID)
);

