package com.joinyon.githubapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public class User implements Parcelable {


    /**
     * login : defunkt
     * id : 2
     * node_id : MDQ6VXNlcjI=
     * avatar_url : https://avatars0.githubusercontent.com/u/2?v=4
     * gravatar_id :
     * url : https://api.github.com/users/defunkt
     * html_url : https://github.com/defunkt
     * followers_url : https://api.github.com/users/defunkt/followers
     * following_url : https://api.github.com/users/defunkt/following{/other_user}
     * gists_url : https://api.github.com/users/defunkt/gists{/gist_id}
     * starred_url : https://api.github.com/users/defunkt/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/defunkt/subscriptions
     * organizations_url : https://api.github.com/users/defunkt/orgs
     * repos_url : https://api.github.com/users/defunkt/repos
     * events_url : https://api.github.com/users/defunkt/events{/privacy}
     * received_events_url : https://api.github.com/users/defunkt/received_events
     * type : User
     * site_admin : true
     * name : Chris Wanstrath
     * company : @github
     * blog : http://chriswanstrath.com/
     * location : San Francisco
     * email :
     * hireable :
     * bio : 🍔
     * public_repos : 107
     * public_gists : 273
     * followers : 20288
     * following : 210
     * created_at : 2007-10-20T05:24:19Z
     * updated_at : 2018-06-25T22:22:14Z
     */

    private String login;
    private int id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
    private String created_at;
    private String updated_at;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeInt(this.id);
        dest.writeString(this.avatar_url);
        dest.writeString(this.gravatar_id);
        dest.writeString(this.url);

        dest.writeString(this.html_url);
        dest.writeString(this.followers_url);
        dest.writeString(this.following_url);
        dest.writeString(this.gists_url);
        dest.writeString(this.starred_url);

        dest.writeString(this.subscriptions_url);
        dest.writeString(this.organizations_url);
        dest.writeString(this.repos_url);
        dest.writeString(this.events_url);
        dest.writeString(this.received_events_url);

        dest.writeString(this.type);
        dest.writeByte(this.site_admin ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
        dest.writeString(this.company);
        dest.writeString(this.blog);

        dest.writeString(this.location);
        dest.writeString(this.email);
        dest.writeString(this.hireable);
        dest.writeString(this.bio);
        dest.writeInt(this.public_repos);

        dest.writeInt(this.public_gists);
        dest.writeInt(this.followers);
        dest.writeInt(this.following);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);


    }

    public User() {


    }

    protected User(Parcel in) {
        this.login = in.readString();
        this.id = in.readInt();
        this.avatar_url = in.readString();
        this.gravatar_id = in.readString();
        this.url = in.readString();

        this.html_url = in.readString();
        this.followers_url = in.readString();
        this.following_url = in.readString();
        this.gists_url = in.readString();
        this.starred_url = in.readString();

        this.subscriptions_url = in.readString();
        this.organizations_url = in.readString();
        this.repos_url = in.readString();
        this.events_url = in.readString();
        this.received_events_url = in.readString();

        this.type = in.readString();
        this.site_admin = in.readByte() != 0;
        this.name = in.readString();
        this.company = in.readString();
        this.blog = in.readString();

        this.location = in.readString();
        this.email = in.readString();
        this.hireable = in.readString();
        this.bio = in.readString();
        this.public_repos = in.readInt();

        this.public_gists = in.readInt();
        this.followers = in.readInt();
        this.following = in.readInt();
        this.created_at = in.readString();
        this.updated_at = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", node_id='" + node_id + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", blog='" + blog + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", hireable='" + hireable + '\'' +
                ", bio='" + bio + '\'' +
                ", public_repos=" + public_repos +
                ", public_gists=" + public_gists +
                ", followers=" + followers +
                ", following=" + following +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
