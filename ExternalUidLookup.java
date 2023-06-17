package org.unitime.timetable.interfaces;

import java.util.StringTokenizer;

public interface ExternalUidLookup {
    public UserInfo lookup(String searchId) throws Exception;
    public UserInfo lookupByExternalId(String externalId) throws Exception;
    public UserInfo lookupByEmail(String email) throws Exception;
    public UserInfo lookupByUserName(String userName) throws Exception;

    public static class UserInfo {
        private String externalId = null;
        private String username = null;
        private String firstName = null;
        private String middleName = null;
        private String lastName = null;
        private String academicTitle = null;
        private String email = null;
        private String name = null;
        private String phone = null;

        public UserInfo() {}

        public String getExternalId() 
		{
            return externalId;
        }
        public void setExternalId(String externalId)
		{
            this.externalId = externalId;
        }

        public String getUsername() 
		{
            return username;
        }
        public void setUsername(String username) 
		{
            this.username = username;
        }

        public String getFirstName() 
		{
            if (firstName != null) 
			{
                return firstName;
            }

            if (name != null) 
			{
                StringTokenizer s = new StringTokenizer(name);
                if (s.countTokens() > 1) 
				{
					return s.nextToken();
				}
            }
            return "";
        }
        public void setFirstName(String firstName) 
		{
            this.firstName = firstName;
        }

        public String getMiddleName() {
            if (middleName != null) 
			{
                return middleName;
            }
            if (name != null) 
			{
                StringTokenizer s = new StringTokenizer(name);
                if (s.countTokens() > 2) 
				{
                    s.nextToken();
                    String m = "";
                    while (true)
					{
                        String n = s.nextToken();
                        if (!s.hasMoreTokens()) 
						{
							break;
						}
                        m += (m.isEmpty() ? "" : " ") + n;
                    }
                    return m;
                }
            }
            return "";
        }
        public void setMiddleName(String middleName) 
		{
            this.middleName = middleName;
        }

        public String getLastName() 
		{
            if (lastName != null) 
			{
                return lastName;
            }
            if (name != null) 
			{
                StringTokenizer s = new StringTokenizer(name);
                if (s.countTokens() > 0) 
				{
                    String l = s.nextToken();
                    while (s.hasMoreTokens()) 
					{
						l = s.nextToken();
					}
                    return l;
                }
            }
            return "";
        }
        public void setLastName(String lastName) 
		{
            this.lastName = lastName;
        }

        public String getEmail() 
		{
            return email;
        }
        public void setEmail(String email) 
		{
            this.email = email;
        }

        public String getPhone() 
		{
            return phone;
        }
        public void setPhone(String phone) 
		{
            this.phone = phone;
        }

        public String getName() 
		{
            if (name != null) 
			{
                return name;
            }
            return ((lastName == null ? "" : lastName) + ", " + (firstName == null ? "" : firstName) + (middleName == null ? "" : " " + middleName)).toString();
        }
        public void setName(String name) 
		{
            this.name = name;
        }

        public void setAcademicTitle(String academicTitle) 
		{
            this.academicTitle = academicTitle;
        }
        public String getAcademicTitle() 
		{
            return academicTitle;
        }
    }
}