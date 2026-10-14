package com.chiikawaraid.common;

public final class GameBalance {
    private GameBalance() {
    }

    // 공통 시작 상태
    public static final int START_GOLD = 150;
    public static final int MAX_MP = 60;
    public static final int START_HP_POTION_COUNT = 2;
    public static final int START_MP_POTION_COUNT = 1;
    public static final int START_ENHANCEMENT_LEVEL = 0;

    // 치이카와
    public static final int CHIIKAWA_MAX_HP = 120;
    public static final int CHIIKAWA_BASE_ATTACK = 16;

    // 하치와레
    public static final int HACHIWARE_MAX_HP = 100;
    public static final int HACHIWARE_BASE_ATTACK = 18;

    // 우사기
    public static final int USAGI_MAX_HP = 90;
    public static final int USAGI_BASE_ATTACK = 20;

    // 공통 공격 스킬
    // 스킬 1: 현재 공격력 + 5
    public static final int SKILL_ONE_MP_COST = 0;
    public static final int SKILL_ONE_DAMAGE_BONUS = 5;

    // 스킬 2: 현재 공격력 × 2 + 5
    public static final int SKILL_TWO_MP_COST = 15;
    public static final int SKILL_TWO_DAMAGE_MULTIPLIER = 2;
    public static final int SKILL_TWO_DAMAGE_BONUS = 5;

    // 캐릭터별 스킬 3
    public static final int SKILL_THREE_MP_COST = 20;

    // 치이카와: 현재 공격력만큼 공격 + 피해 75% 감소
    public static final int CHIIKAWA_DAMAGE_REDUCTION_PERCENT = 75;

    // 하치와레: 현재 공격력만큼 공격 + 피해 100% 감소
    public static final int HACHIWARE_DAMAGE_REDUCTION_PERCENT = 100;

    // 우사기: HP 45 회복
    public static final int USAGI_SKILL_HP_RECOVERY = 45;

    // 공통 방어
    public static final int DEFEND_DAMAGE_REDUCTION_PERCENT = 50;
    public static final int DEFEND_MP_RECOVERY = 15;

    // 회복 아이템
    public static final int HP_POTION_PRICE = 30;
    public static final int HP_POTION_RECOVERY = 40;

    public static final int MP_POTION_PRICE = 40;
    public static final int MP_POTION_RECOVERY = 30;

    public static final int MAX_POTION_COUNT_PER_TYPE = 5;

    // 무기 강화
    public static final int MAX_ENHANCEMENT_LEVEL = 3;
    public static final int ATTACK_PER_ENHANCEMENT = 3;

    // 해당 단계로 올라가는 데 필요한 비용
    public static final int ENHANCEMENT_LEVEL_ONE_COST = 60;
    public static final int ENHANCEMENT_LEVEL_TWO_COST = 90;
    public static final int ENHANCEMENT_LEVEL_THREE_COST = 120;

    // 일반 적: 들판의 작은 괴물
    public static final int SMALL_MONSTER_MAX_HP = 45;
    public static final int SMALL_MONSTER_ATTACK = 6;
    public static final int SMALL_MONSTER_GOLD_REWARD = 70;

    // 일반 적: 동굴의 큰 괴물
    public static final int LARGE_MONSTER_MAX_HP = 80;
    public static final int LARGE_MONSTER_ATTACK = 10;
    public static final int LARGE_MONSTER_GOLD_REWARD = 110;

    // 세이렌
    public static final int SIREN_MAX_HP = 300;
    public static final int SIREN_PHASE_TWO_HP_THRESHOLD = 150;

    public static final int SIREN_PHASE_ONE_NORMAL_DAMAGE = 18;
    public static final int SIREN_PHASE_ONE_HEAVY_DAMAGE = 40;

    public static final int SIREN_PHASE_TWO_NORMAL_DAMAGE = 24;
    public static final int SIREN_PHASE_TWO_HEAVY_DAMAGE = 46;

    // 3, 6, 9...턴에 강공격
    public static final int SIREN_HEAVY_ATTACK_INTERVAL = 3;
}