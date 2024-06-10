CREATE TABLE NOTIFICATION (
    notification_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    title VARCHAR(50) NOT NULL ,
    message TEXT,
    notification_status VARCHAR(50) CHECK( notification_status  IN ('CREATED', 'READ')) NOT NULL,
    creation_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);