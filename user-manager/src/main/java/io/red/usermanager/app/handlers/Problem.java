package io.red.usermanager.app.handlers;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {
    private Integer status;
    private OffsetDateTime timestamp;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private List<Object> objects;

    public Problem(Integer status, OffsetDateTime timestamp, String type, String title, String detail,
                   String userMessage,
                   List<Object> objects) {
        this.status = status;
        this.timestamp = timestamp;
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.userMessage = userMessage;
        this.objects = objects;
    }

    public static ProblemBuilder builder() {
        return new ProblemBuilder();
    }

    public static class Object {

        private String name;
        private String userMessage;

        public Object(String name, String userMessage) {
            this.name = name;
            this.userMessage = userMessage;
        }

        public static ObjectBuilder builder() {
            return new ObjectBuilder();
        }

        public static class ObjectBuilder {

            private String name;
            private String userMessage;

            public ObjectBuilder name(String name) {
                this.name = name;
                return this;
            }

            public ObjectBuilder userMessage(String message) {
                this.userMessage = message;
                return this;
            }

            public Object build() {
                return new Object(this.name, this.userMessage);
            }
        }

        public String getName() {
            return name;
        }

        public String getUserMessage() {
            return userMessage;
        }
    }

    public static class ProblemBuilder {
        private Integer status;
        private OffsetDateTime timestamp;
        private String type;
        private String title;
        private String detail;
        private String userMessage;
        private List<Object> objects;

        public ProblemBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ProblemBuilder timestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ProblemBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ProblemBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProblemBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public ProblemBuilder userMessage(String userMessage) {
            this.userMessage = userMessage;
            return this;
        }

        public ProblemBuilder objects(List<Object> objects) {
            this.objects = objects;
            return this;
        }

        public Problem build() {
            return new Problem(
                status,
                timestamp,
                type,
                title,
                detail,
                userMessage,
                objects
            );
        }
    }

    public Integer getStatus() {
        return status;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public List<Object> getObjects() {
        return objects;
    }
}
