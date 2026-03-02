# GitHub Actions - Scheduled Test Execution Guide

This guide explains how to use GitHub Actions to automatically run your Selenium tests on a schedule - **completely free**! ✅

---

## 🎯 What You Get (Free Tier)

### GitHub Actions Free Benefits:
- ✅ **Unlimited free minutes** for public repositories
- ✅ **2,000 free minutes/month** for private repositories  
- ✅ **Job timeout:** Up to 6 hours per job
- ✅ **Workflow timeout:** Up to 35 days
- ✅ **Concurrency:** 20 concurrent jobs

**Scroll down for pricing details:** https://docs.github.com/en/actions

---

## 📅 Scheduled Workflows Included

### Workflow 1: Main Workflow (`.github/workflows/tests.yml`)

**Triggers:**
| Trigger | Schedule |
|---------|----------|
| 🔔 Daily | 2:00 AM UTC (`0 2 * * *`) |
| 📅 Weekly | Monday 9:00 AM UTC (`0 9 * * 1`) |
| 🔘 Manual | Anytime via Actions tab |
| 📤 On Push | Any push to main/develop |
| 🔀 On PR | Any pull request |

### Workflow 2: Dedicated Scheduled Tests (`.github/workflows/scheduled-tests.yml`)

**Triggers:**
| Trigger | Schedule |
|---------|----------|
| ⏰ Weekday | Mon-Fri at 2:00 AM UTC (`0 2 * * 1-5`) |
| 📊 Weekend | Sunday at 8:00 PM UTC (`0 20 * * 0`) |
| 🔘 Manual | Anytime via Actions tab |

**Features:**
- Optimized for free tier (lower memory usage)
- Focused regression tests only
- Minimal artifacts (saves storage)
- Better concurrency control

---

## 🚀 Setup Instructions

### Step 1: Push Files to GitHub

The workflow files are already created:
- `.github/workflows/tests.yml` - Main workflow
- `.github/workflows/scheduled-tests.yml` - Scheduled tests

Just push to your repository:
```bash
git add .github/workflows/
git commit -m "Add GitHub Actions scheduled workflows"
git push origin main
```

### Step 2: Verify Workflows are Active

1. Go to your GitHub repository
2. Click **Actions** tab
3. You should see:
   - ✅ "Selenium Automation Tests"
   - ✅ "Scheduled Regression Tests"

### Step 3: (Optional) Configure Environment Variables

Add secrets for sensitive data:

1. Go to **Settings** → **Secrets and variables** → **Actions**
2. Click **New repository secret**
3. Add your secrets:
   ```
   PROD_USERNAME = your_username
   PROD_PASSWORD = your_password
   API_KEY = your_api_key
   ```

### Step 4: (Optional) Add Slack Notifications

For failure notifications, add Slack webhook:

1. Create Slack incoming webhook: https://api.slack.com/messaging/webhooks
2. Copy webhook URL
3. In GitHub: **Settings** → **Secrets** → **New repository secret**
4. Name: `SLACK_WEBHOOK_URL`
5. Value: Your webhook URL

---

## 📊 CRON Schedule Reference

Understanding cron expressions: `minute hour day month day-of-week`

### Common Schedules:

```bash
# Daily at 2 AM UTC
0 2 * * *

# Daily at 2 PM UTC  
0 14 * * *

# Every Monday at 9 AM UTC
0 9 * * 1

# Every weekday (Mon-Fri) at 10 AM UTC
0 10 * * 1-5

# Every day at midnight UTC
0 0 * * *

# Twice daily (2 AM and 2 PM UTC)
0 2,14 * * *

# Every 6 hours
0 */6 * * *

# Every Sunday at 8 PM UTC
0 20 * * 0

# Every 1st and 15th of month at noon UTC
0 12 1,15 * *
```

### ⚠️ Important: GitHub Actions runs in UTC

If your schedule doesn't seem right, check your timezone conversion:
- **UTC to EST:** Subtract 5 hours (or 4 during daylight saving)
- **UTC to PST:** Subtract 8 hours (or 7 during daylight saving)
- **UTC to IST:** Add 5.5 hours

---

## 🎮 Manual Trigger (No Schedule Required)

You can run tests anytime without waiting for schedule:

1. Go to **Actions** tab
2. Select **"Selenium Automation Tests"**
3. Click **"Run workflow"**
4. Choose environment (local/dev/qa/staging)
5. Click **"Run workflow"**

Tests start immediately! ⚡

---

## 📋 How to Customize Schedules

### Edit Main Workflow

File: `.github/workflows/tests.yml`

```yaml
schedule:
  # Run daily at 2:00 AM UTC
  - cron: '0 2 * * *'
  
  # Run weekly on Monday at 9:00 AM UTC
  - cron: '0 9 * * 1'
```

### Edit Scheduled Tests Workflow

File: `.github/workflows/scheduled-tests.yml`

```yaml
schedule:
  # Run weekdays at 2 AM UTC
  - cron: '0 2 * * 1-5'
  
  # Run Sundays at 8 PM UTC
  - cron: '0 20 * * 0'
```

**After editing, commit and push:**
```bash
git add .github/workflows/*.yml
git commit -m "Update test schedules"
git push origin main
```

Changes take effect immediately!

---

## 🔍 Monitor Scheduled Runs

### View All Runs

1. Go to **Actions** tab
2. See all workflow runs with status
3. Click run to see details

### View Scheduled Run Details

1. Click on a workflow run
2. See step-by-step logs
3. Download artifacts (reports, screenshots)

### Check Next Scheduled Run

1. Go to **Actions** tab
2. Click on workflow name
3. Scroll down to see next scheduled run time

### View Workflow Logs

1. Click on workflow run
2. Expand steps to see output
3. Search for errors in logs

---

## 📊 Understanding Test Results

### After Each Scheduled Run:

✅ **Success:**
- Green checkmark
- Tests passed
- Reports saved as artifacts

❌ **Failure:**
- Red X mark
- See logs for error details
- Download artifacts to debug
- Screenshots available

📋 **Summary:**
- Test count
- Pass/fail ratio
- Execution time
- Report location

---

## 💡 Free Tier Optimization Tips

### 1. **Avoid Overlapping Schedules**
```yaml
# Bad - both run at 2 AM, could use double minutes
schedule:
  - cron: '0 2 * * *'    # Daily
  - cron: '0 2 * * 1'    # Monday (same time!)

# Good - different times
schedule:
  - cron: '0 2 * * 1-5'  # Daily Mon-Fri
  - cron: '0 14 * * 0'   # Sunday different time
```

### 2. **Reduce Test Frequency**
```yaml
# Instead of daily, run 3 times per week
schedule:
  - cron: '0 2 * * 0,2,4'  # Sun, Tue, Thu
```

### 3. **Use Concurrency Control**
```yaml
concurrency:
  group: scheduled-tests
  cancel-in-progress: false
```

### 4. **Optimize Test Environment**
```yaml
env:
  MAVEN_OPTS: '-Xmx512m'  # Use less memory
```

### 5. **Limit Artifacts**
```yaml
retention-days: 7  # Delete old artifacts after 7 days
```

---

## 🚨 Troubleshooting

### Issue: Schedule Not Running

**Possible causes:**
1. Default branch is not main/develop
2. Workflow file has syntax error
3. Workflow is disabled

**Solution:**
```bash
# Check if workflow is enabled
# Settings → Actions → General → Allow all actions

# Verify branch name
git branch

# Validate YAML syntax
# Use online tool: https://www.yamllint.com/
```

### Issue: Workflow Disabled After Inactivity

GitHub disables workflows on public repos after 60 days of no commits.

**Solution:**
- Make a commit to main branch
- Or manually trigger a run
- Workflows will re-enable

### Issue: Tests Take Too Long

**Solution:**
1. Reduce number of tests
2. Run only regression suite with tags
3. Use headless mode
4. Increase timeout if needed

### Issue: "Insufficient Quota"

If you hit free tier limit:
- Optimize schedules (run less frequently)
- Reduce test duration
- Or upgrade to paid plan

### Issue: Can't See Artifacts

**Solution:**
1. Artifacts expire after retention-days
2. Download before expiration
3. Increase retention-days if needed (uses storage):
```yaml
retention-days: 30  # Keep for 30 days
```

---

## 📈 Monitoring with GitHub Insights

### View Action Hours Used

1. Go to **Settings** → **Billing and plans**
2. Click **Actions**
3. See monthly usage
4. Current usage for current month

### Set Usage Alert

1. **Settings** → **Billing and plans** → **Actions**
2. Set spending limit (optional)
3. Get notified when limit reached

---

## 🔐 Security Best Practices

### 1. **Never Commit Credentials**
```bash
# ❌ Wrong - Credentials in config
browser=chrome
username=admin
password=password123  # NEVER!

# ✅ Right - Use secrets
PROD_USERNAME=${{ secrets.PROD_USERNAME }}
```

### 2. **Use Organization Secrets for Multiple Repos**
1. **Settings** → **Secrets and variables** → **Actions**
2. Create **Organization secrets** (available to all repos)
3. Reference in workflows

### 3. **Limit Secret Exposure**
```yaml
# Only run on specific events
if: github.event_name == 'workflow_dispatch'

# Only on certain branches
if: github.ref == 'refs/heads/main'
```

### 4. **Audit Secret Usage**
1. **Settings** → **Audit log**
2. See all secret access
3. Monitor for suspicious activity

---

## 🎓 Real-World Examples

### Example 1: Daily Smoke Tests
```yaml
schedule:
  - cron: '0 6 * * *'  # 6 AM UTC daily
```
Run quick smoke tests before business hours.

### Example 2: Weekend Full Regression
```yaml
schedule:
  - cron: '0 0 * * 0'  # Sunday midnight UTC
```
Run full test suite when no one's working.

### Example 3: Multiple Environments
```yaml
schedule:
  - cron: '0 2 * * 1'   # Dev on Monday
  - cron: '0 2 * * 2'   # QA on Tuesday  
  - cron: '0 2 * * 3'   # Staging on Wednesday
```
Test different environments on different days.

### Example 4: Off-Peak Testing
```yaml
schedule:
  - cron: '0 22 * * *'  # 10 PM UTC daily
```
Run during off-peak hours to avoid blocking developers.

---

## 📞 Getting Help

### GitHub Actions Documentation
- https://docs.github.com/en/actions
- https://docs.github.com/en/actions/learn-github-actions

### Cron Syntax Help
- https://crontab.guru/ - Visual cron builder
- https://www.freeformatter.com/cron-expression-generator-quartz.html

### Troubleshooting
- [GitHub Actions Troubleshooting](https://docs.github.com/en/actions/troubleshooting)
- Search repository issues
- Create new issue with logs

---

## ✨ Summary

| Feature | Status | Cost |
|---------|--------|------|
| Scheduled execution | ✅ Enabled | FREE |
| Daily runs | ✅ Unlimited | FREE |
| Manual triggers | ✅ Enabled | FREE |
| Test reports | ✅ Artifacts | FREE |
| Email notifications | ✅ Available | FREE |
| Slack notifications | ✅ Possible | FREE |

**Everything is completely FREE! 🎉**

---

## 🚀 Next Steps

1. ✅ Push code to GitHub
2. ✅ Verify workflows in Actions tab
3. ✅ Adjust schedule times as needed
4. ✅ Monitor first scheduled run
5. ✅ (Optional) Add notifications
6. ✅ Enjoy automated testing!

---

**Happy automated testing! 🤖✨**

*Note: Schedules may be delayed during GitHub maintenance. For exact timing guarantees, use paid GitHub Actions.*
