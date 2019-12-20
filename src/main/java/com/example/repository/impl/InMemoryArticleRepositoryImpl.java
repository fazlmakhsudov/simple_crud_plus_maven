package com.example.repository.impl;

import com.example.entity.Article;
import com.example.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of PublicationRepository concerning internal memory
 */
public class InMemoryArticleRepositoryImpl implements ArticleRepository {


    private final Map<Long, Article> memory;
    private long index;


    public InMemoryArticleRepositoryImpl(final Map<Long, Article> memory, final long startIndex) {
        this.memory = memory;
        this.index = startIndex;
    }

    @Override
    public long create(final Article item) {
        item.setId(index);
        memory.put(index, item);
        return index++;
    }

    @Override
    public Article read(final long id) {
        return memory.getOrDefault(id, null);
    }

    @Override
    public boolean update(final Article item) {
        if (!memory.containsKey(item.getId())) {
            return false;
        }
        memory.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean delete(final long id) {
        if (!memory.containsKey(id)) {
            return false;
        }
        memory.remove(id);
        return true;
    }

    @Override
    public List<Article> getAll() {
        return new ArrayList<>(memory.values());
    }

    @Override
    public List<Article> getAllByUserId(long user_id) {
        return memory.values().stream()
                .filter((article) -> article.matchUserId(user_id))
                .collect(Collectors.toList());
    }

    @Override
    public Article getByTitle(String title) {
        Article article = null;
        for (Article article1 : memory.values()) {
            if (article1.matchTitle(title)) {
                article = article1;
                break;
            }
        }
        return article;
    }
}
