package com.example.home

import com.example.home.data.remote.dto.*
import com.example.home.data.remote.dto.NewsDTO

/**
 * created by Karim Haggagi Hassan Elsayed on 5/14/25
 **/
fun createFakeNewsDTO(): NewsDTO {
    val fakeOembed = Oembed(
        author_name = "Fake Author",
        author_url = "https://fake.com/author",
        height = 100,
        html = "<p>Fake HTML</p>",
        provider_name = "Fake Provider",
        provider_url = "https://fake.com/provider",
        thumbnail_height = 50,
        thumbnail_url = "https://fake.com/thumbnail.jpg",
        thumbnail_width = 50,
        title = "Fake Oembed Title",
        type = "rich",
        version = "1.0",
        width = 100
    )

    val fakeMedia = Media(
        oembed = fakeOembed,
        type = "oembed"
    )

    val fakeMediaEmbedX = MediaEmbedX(
        content = "&lt;a href=\"https://fake.com\"&gt;Fake Content&lt;/a&gt;",
        height = 200,
        scrolling = false,
        width = 300
    )

    val fakeSecureMedia = SecureMedia(
        oembed = fakeOembed,
        type = "oembed"
    )

    val fakeSecureMediaEmbedX = SecureMediaEmbedX(
        content = "&lt;a href=\"https://fake.com\"&gt;Fake Content&lt;/a&gt;",
        height = 200,
        media_domain_url = "https://fake.com",
        scrolling = false,
        width = 300
    )


    val fakeChildrenData = ChildrenData(
        all_awardings = listOf(),
        allow_live_comments = true,
        approved_at_utc = null,
        approved_by = null,
        archived = false,
        author = "Fake User",
        author_flair_background_color = null,
        author_flair_css_class = null,
        author_flair_richtext = listOf(),
        author_flair_template_id = null,
        author_flair_text = null,
        author_flair_text_color = null,
        author_flair_type = "text",
        author_fullname = "t2_fakeuser",
        author_is_blocked = false,
        author_patreon_flair = false,
        author_premium = false,
        awarders = listOf(),
        banned_at_utc = null,
        banned_by = null,
        can_gild = true,
        can_mod_post = false,
        category = null,
        clicked = false,
        content_categories = null,
        contest_mode = false,
        created = 1678886400.0, // Sample timestamp
        created_utc = 1678886400.0, // Sample timestamp
        crosspost_parent = null,
        crosspost_parent_list = listOf(),
        discussion_type = null,
        distinguished = null,
        domain = "fake.com",
        downs = 0,
        edited = false,
        gilded = 0,
        gildings = GildingsX(),
        hidden = false,
        hide_score = false,
        id = "fakeid123",
        is_created_from_ads_ui = false,
        is_crosspostable = true,
        is_meta = false,
        is_original_content = false,
        is_reddit_media_domain = false,
        is_robot_indexable = true,
        is_self = false,
        is_video = false,
        likes = null,
        link_flair_background_color = "",
        link_flair_css_class = null,
        link_flair_richtext = listOf(),
        link_flair_text = null,
        link_flair_text_color = "dark",
        link_flair_type = "text",
        locked = false,
        media = fakeMedia,
        media_embed = fakeMediaEmbedX,
        media_only = false,
        mod_note = null,
        mod_reason_by = null,
        mod_reason_title = null,
        mod_reports = listOf(),
        name = "t3_fakeid123",
        no_follow = false,
        num_comments = 10,
        num_crossposts = 0,
        num_reports = null,
        over_18 = false,
        permalink = "/r/fakereddit/comments/fakeid123/faketitle/",
        pinned = false,
        pwls = 6,
        quarantine = false,
        removal_reason = null,
        removed_by = null,
        removed_by_category = null,
        report_reasons = null,
        saved = false,
        score = 100,
        secure_media = fakeSecureMedia,
        secure_media_embed = fakeSecureMediaEmbedX,
        selftext = "This is some fake selftext.",
        selftext_html = "&lt;div class=\"md\"&gt;&lt;p&gt;This is some fake selftext.&lt;/p&gt;\n&lt;/div&gt;",
        send_replies = true,
        spoiler = false,
        stickied = false,
        subreddit = "fakereddit",
        subreddit_id = "t5_fake",
        subreddit_name_prefixed = "r/fakereddit",
        subreddit_subscribers = 1000,
        subreddit_type = "public",
        suggested_sort = null,
        thumbnail = "https://fake.com/thumbnail.jpg",
        title = "Fake News Title",
        top_awarded_type = null,
        total_awards_received = 0,
        treatment_tags = listOf(),
        ups = 100,
        upvote_ratio = 1.0,
        url = "https://fake.com/post",
        url_overridden_by_dest = "https://fake.com/destination",
        user_reports = listOf(),
        view_count = null,
        visited = false,
        wls = 6
    )

    val fakeChildren = Children(
        childrenData = fakeChildrenData,
        kind = "t3"
    )

    val fakeData = Data(
        after = "fakeafter",
        before = null,
        children = listOf(fakeChildren),
        dist = 1,
        geo_filter = null,
        modhash = "fakemodhash"
    )

    return NewsDTO(
        newsData = fakeData,
        kind = "Listing"
    )
}