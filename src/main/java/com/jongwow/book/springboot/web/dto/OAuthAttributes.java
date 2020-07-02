package com.jongwow.book.springboot.web.dto;

import com.jongwow.book.springboot.domain.user.Role;
import com.jongwow.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attribute) {
        return ofGoogle(userNameAttributeName, attribute);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attribute) {
        return OAuthAttributes.builder()
                .name((String) attribute.get("name"))
                .email((String) attribute.get("email"))
                .picture((String) attribute.get("picture"))
                .attributes(attribute)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    /*
     * User Entity 생성
     * OAuthAttritbutes에서 엔티티를 생성하는 시점은 처음 가입시
     * 가입시 기본 권한은 GUEST
     * */
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
