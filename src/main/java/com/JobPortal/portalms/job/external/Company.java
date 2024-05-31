package com.JobPortal.portalms.job.external;




    public class Company {


        private Long id;
        private String name;
        private String description;

//    @JsonIgnore
//    @OneToMany(mappedBy = "company")
//    private List<Job> jobList;
//
//    @OneToMany(mappedBy = "company")
//    private List<Review> reviews;

        public Company(Long id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
//        this.jobList = jobList;
//        this.reviews = reviews;
        }

        public Company() {
        }

//    public List<Review> getReviews() {
//        return reviews;
//    }

//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

//    public List<Job> getJobList() {
//        return jobList;
//    }
//
//    public void setJobList(List<Job> jobList) {
//        this.jobList = jobList;
//    }
    }


